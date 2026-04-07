const express = require('express');
const path = require('path');
const fs = require('fs');
const { marked } = require('marked');

const app = express();
const PORT = process.env.PORT || 3000;

const SPEC_DIR = path.join(__dirname, 'spec');
const MOCKUP_DIR = path.join(SPEC_DIR, 'mockup');

app.use('/mockup', express.static(MOCKUP_DIR));

app.get('/', (req, res) => {
    res.send(`
        <!DOCTYPE html>
        <html>
        <head>
            <title>Asset Management System</title>
            <style>
                body { font-family: Arial, sans-serif; margin: 40px; background: #f5f5f5; }
                .container { max-width: 800px; margin: 0 auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }
                h1 { color: #333; }
                .links { display: grid; grid-template-columns: repeat(auto-fill, minmax(250px, 1fr)); gap: 15px; margin-top: 20px; }
                a { display: block; padding: 15px 20px; background: #007bff; color: white; text-decoration: none; border-radius: 5px; text-align: center; transition: background 0.3s; }
                a:hover { background: #0056b3; }
                .description { color: #666; margin-top: 10px; }
            </style>
        </head>
        <body>
            <div class="container">
                <h1>Asset Management System</h1>
                <p class="description">Specification and Mockup Viewer</p>
                <div class="links">
                    <a href="/mockup">UI Mockups</a>
                    <a href="/spec">Requirements (Markdown)</a>
                </div>
            </div>
        </body>
        </html>
    `);
});

app.get('/spec', (req, res) => {
    const requestedPath = req.query.path || '';
    const fullPath = path.join(SPEC_DIR, requestedPath);

    if (!fullPath.startsWith(SPEC_DIR)) {
        return res.status(403).send('Access denied');
    }

    if (fs.statSync(fullPath).isDirectory()) {
        const files = fs.readdirSync(fullPath);
        const html = `
            <!DOCTYPE html>
            <html>
            <head>
                <title>${path.basename(fullPath) || 'Spec'}</title>
                <style>
                    body { font-family: Arial, sans-serif; margin: 40px; background: #f5f5f5; }
                    .container { max-width: 900px; margin: 0 auto; background: white; padding: 30px; border-radius: 8px; }
                    h1 { color: #333; border-bottom: 2px solid #007bff; padding-bottom: 10px; }
                    ul { list-style: none; padding: 0; }
                    li { padding: 10px 0; border-bottom: 1px solid #eee; }
                    a { color: #007bff; text-decoration: none; font-size: 16px; }
                    a:hover { text-decoration: underline; }
                    .folder { color: #f0ad4e; margin-right: 8px; }
                    .file { color: #5bc0de; margin-right: 8px; }
                    .breadcrumb { color: #666; margin-bottom: 20px; }
                    .back { display: inline-block; margin-bottom: 20px; padding: 8px 16px; background: #6c757d; color: white; text-decoration: none; border-radius: 4px; }
                </style>
            </head>
            <body>
                <div class="container">
                    <a href="/spec" class="back">Root</a>
                    ${requestedPath ? `<a href="/spec?path=${path.dirname(requestedPath)}" class="back" style="margin-left:10px;">Parent</a>` : ''}
                    <h1>${path.basename(fullPath) || 'Specification'}</h1>
                    <ul>
                        ${files.map(f => {
                            const isDir = fs.statSync(path.join(fullPath, f)).isDirectory();
                            const newPath = requestedPath ? `${requestedPath}/${f}` : f;
                            return `<li><a href="${isDir ? `/spec?path=${newPath}` : `/spec${newPath}`}"><span class="${isDir ? 'folder' : 'file'}">${isDir ? '📁' : '📄'}</span>${f}</a></li>`;
                        }).join('')}
                    </ul>
                </div>
            </body>
            </html>
        `;
        res.send(html);
    } else if (fullPath.endsWith('.md')) {
        const content = fs.readFileSync(fullPath, 'utf-8');
        const html = marked(content);
        const title = path.basename(fullPath, '.md');
        res.send(`
            <!DOCTYPE html>
            <html>
            <head>
                <title>${title}</title>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/github-markdown-css@5.0.0/github-markdown.min.css">
                <style>
                    body { font-family: Arial, sans-serif; margin: 0; background: #f5f5f5; }
                    .container { max-width: 900px; margin: 0 auto; padding: 40px 20px; }
                    .markdown-body { background: white; padding: 40px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }
                    .back { display: inline-block; margin-bottom: 20px; padding: 8px 16px; background: #6c757d; color: white; text-decoration: none; border-radius: 4px; }
                    table { border-collapse: collapse; width: 100%; margin: 20px 0; }
                    th, td { border: 1px solid #ddd; padding: 8px 12px; text-align: left; }
                    th { background: #f8f9fa; }
                    code { background: #f4f4f4; padding: 2px 6px; border-radius: 3px; }
                    pre { background: #f4f4f4; padding: 15px; border-radius: 5px; overflow-x: auto; }
                </style>
            </head>
            <body>
                <div class="container">
                    <a href="/spec" class="back">Root</a>
                    ${requestedPath ? `<a href="/spec?path=${path.dirname(requestedPath)}" class="back" style="margin-left:10px;">Parent</a>` : ''}
                    <div class="markdown-body">
                        <h1>${title}</h1>
                        ${html}
                    </div>
                </div>
            </body>
            </html>
        `);
    } else {
        res.status(404).send('File not found');
    }
});

app.listen(PORT, () => {
    console.log(`Server running at http://localhost:${PORT}`);
    console.log(`Mockups: http://localhost:${PORT}/mockup`);
    console.log(`Requirements: http://localhost:${PORT}/spec`);
});