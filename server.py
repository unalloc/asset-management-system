#!/usr/bin/env python3
import http.server
import socketserver
import os
import re
from urllib.parse import unquote, urlparse

PORT = 3000
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
SPEC_DIR = os.path.join(BASE_DIR, "spec")
MOCKUP_DIR = os.path.join(BASE_DIR, "mockup")


class Handler(http.server.SimpleHTTPRequestHandler):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, directory=BASE_DIR, **kwargs)

    def do_GET(self):
        path = urlparse(self.path).path
        path = unquote(path)

        if path == "/" or path == "":
            self.send_home()
        elif path.startswith("/mockup"):
            self.path = path[len("/mockup") :] if path.startswith("/mockup") else path
            if self.path == "" or self.path == "/":
                self.path = "/index.html"
            self.path = "/mockup" + self.path
            super().do_GET()
        elif path.startswith("/spec"):
            self.send_spec(path)
        else:
            self.send_error(404)

    def send_home(self):
        html = """<!DOCTYPE html>
<html>
<head>
    <title>Asset Management System</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background: #f5f5f5; }
        .container { max-width: 800px; margin: 0 auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }
        h1 { color: #333; }
        .links { display: grid; grid-template-columns: repeat(auto-fill, minmax(250px, 1fr)); gap: 15px; margin-top: 20px; }
        a { display: block; padding: 15px 20px; background: #007bff; color: white; text-decoration: none; border-radius: 5px; text-align: center; transition: background 0.3s; }
        a:hover { background: #0056b3; color: white; text-decoration: none; }
        .description { color: #666; margin-top: 10px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Asset Management System</h1>
        <p class="description">Enterprise EAM Specification for Manufacturing - US/EU Markets</p>
        <div class="links">
            <a href="/mockup">UI Mockups</a>
            <a href="/spec">Requirements (Markdown)</a>
        </div>
    </div>
</body>
</html>"""
        self.send_response(200)
        self.send_header("Content-Type", "text/html")
        self.end_headers()
        self.wfile.write(html.encode())

    def send_spec(self, path):
        path = path.replace("/spec", "")
        if not path:
            path = "/"

        full_path = os.path.join(SPEC_DIR, path.lstrip("/"))

        if not os.path.exists(full_path):
            self.send_error(404)
            return

        if not full_path.startswith(SPEC_DIR):
            self.send_error(403)
            return

        if os.path.isdir(full_path):
            self.send_directory(full_path, path)
        elif full_path.endswith(".md"):
            self.send_markdown(full_path, path)
        else:
            self.send_error(404)

    def send_directory(self, full_path, url_path):
        try:
            files = sorted(os.listdir(full_path))
        except Exception:
            files = []

        parent = os.path.dirname(url_path.rstrip("/"))

        items = []
        for f in files:
            is_dir = os.path.isdir(os.path.join(full_path, f))
            icon = "📁" if is_dir else "📄"
            href = f"/spec{url_path}/{f}" if is_dir else f"/spec{url_path}/{f}"
            items.append(
                f'<li><a href="{href}"><span class="{"folder" if is_dir else "file"}">{icon}</span>{f}</a></li>'
            )

        parent_link = (
            f'<a href="/spec{parent}" class="back" style="margin-left:10px;">Parent</a>'
            if parent != "/"
            else ""
        )

        html = f"""<!DOCTYPE html>
<html>
<head>
    <title>{os.path.basename(full_path) or "Spec"}</title>
    <style>
        body {{ font-family: Arial, sans-serif; margin: 40px; background: #f5f5f5; }}
        .container {{ max-width: 900px; margin: 0 auto; background: white; padding: 30px; border-radius: 8px; }}
        h1 {{ color: #333; border-bottom: 2px solid #007bff; padding-bottom: 10px; }}
        ul {{ list-style: none; padding: 0; }}
        li {{ padding: 10px 0; border-bottom: 1px solid #eee; }}
        a {{ color: #007bff; text-decoration: none; font-size: 16px; }}
        a:hover {{ text-decoration: underline; }}
        .folder {{ color: #f0ad4e; margin-right: 8px; }}
        .file {{ color: #5bc0de; margin-right: 8px; }}
        .back {{ display: inline-block; margin-bottom: 20px; padding: 8px 16px; background: #6c757d; color: white; text-decoration: none; border-radius: 4px; }}
    </style>
</head>
<body>
    <div class="container">
        <a href="/spec" class="back">Root</a>
        {parent_link}
        <h1>{os.path.basename(full_path) or "Specification"}</h1>
        <ul>
            {"".join(items)}
        </ul>
    </div>
</body>
</html>"""
        self.send_response(200)
        self.send_header("Content-Type", "text/html")
        self.end_headers()
        self.wfile.write(html.encode())

    def send_markdown(self, full_path, url_path):
        try:
            with open(full_path, "r", encoding="utf-8") as f:
                content = f.read()
        except Exception:
            self.send_error(500)
            return

        html_content = self.markdown_to_html(content)
        title = os.path.basename(full_path, ".md")
        parent = os.path.dirname(url_path.rstrip("/"))
        parent_link = (
            f'<a href="/spec{parent}" class="back" style="margin-left:10px;">Parent</a>'
            if parent != "/"
            else ""
        )

        html = f"""<!DOCTYPE html>
<html>
<head>
    <title>{title}</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/github-markdown-css@5.0.0/github-markdown.min.css">
    <style>
        body {{ font-family: Arial, sans-serif; margin: 0; background: #f5f5f5; }}
        .container {{ max-width: 900px; margin: 0 auto; padding: 40px 20px; }}
        .markdown-body {{ background: white; padding: 40px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }}
        .back {{ display: inline-block; margin-bottom: 20px; padding: 8px 16px; background: #6c757d; color: white; text-decoration: none; border-radius: 4px; }}
        table {{ border-collapse: collapse; width: 100%; margin: 20px 0; }}
        th, td {{ border: 1px solid #ddd; padding: 8px 12px; text-align: left; }}
        th {{ background: #f8f9fa; }}
        code {{ background: #f4f4f4; padding: 2px 6px; border-radius: 3px; }}
        pre {{ background: #f4f4f4; padding: 15px; border-radius: 5px; overflow-x: auto; }}
    </style>
</head>
<body>
    <div class="container">
        <a href="/spec" class="back">Root</a>
        {parent_link}
        <div class="markdown-body">
            <h1>{title}</h1>
            {html_content}
        </div>
    </div>
</body>
</html>"""
        self.send_response(200)
        self.send_header("Content-Type", "text/html")
        self.end_headers()
        self.wfile.write(html.encode())

    def markdown_to_html(self, md):
        lines = md.split("\n")
        html_lines = []
        in_ul = False

        for line in lines:
            line = line.rstrip()

            if line.startswith("### "):
                if in_ul:
                    html_lines.append("</ul>")
                    in_ul = False
                html_lines.append(f"<h3>{line[4:]}</h3>")
            elif line.startswith("## "):
                if in_ul:
                    html_lines.append("</ul>")
                    in_ul = False
                html_lines.append(f"<h2>{line[3:]}</h2>")
            elif line.startswith("# "):
                if in_ul:
                    html_lines.append("</ul>")
                    in_ul = False
                html_lines.append(f"<h1>{line[2:]}</h1>")
            elif line.startswith("- "):
                if not in_ul:
                    html_lines.append("<ul>")
                    in_ul = True
                html_lines.append(f"<li>{line[2:]}</li>")
            elif line.strip() == "":
                if in_ul:
                    html_lines.append("</ul>")
                    in_ul = False
            else:
                if in_ul:
                    html_lines.append("</ul>")
                    in_ul = False
                line = line.replace("**", "<strong>").replace("**", "</strong>")
                line = line.replace("*", "<em>").replace("*", "</em>")
                line = line.replace("`", "<code>").replace("`", "</code>")
                if line:
                    html_lines.append(f"<p>{line}</p>")

        if in_ul:
            html_lines.append("</ul>")

        result = "\n".join(html_lines)
        result = re.sub(r"<p>\s*</p>", "", result)
        result = re.sub(r"<p>(<h[123]>)", r"\1", result)
        result = re.sub(r"(</h[123]>)</p>", r"\1", result)

        return result


if __name__ == "__main__":
    with socketserver.TCPServer(("", PORT), Handler) as httpd:
        print(f"Server running at http://localhost:{PORT}")
        print(f"  Home: http://localhost:{PORT}")
        print(f"  Mockups: http://localhost:{PORT}/mockup")
        print(f"  Requirements: http://localhost:{PORT}/spec")
        httpd.serve_forever()
