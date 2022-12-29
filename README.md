该项目有两个分支。main 分支是后端代码，front 分支是前端代码。

如何配置和运行本项目：

1. 考虑到每个人的数据库密码等不一样，请在 `main` 分支的 `src/main/resources` 找到 `eg.properties`，将其重命名为 `application.properties`，并修改数据库用户密码配置

2. 启动数据库。将 `main` 分支的 `env/data.sql` 里包含本项目所用的数据库导入。

3. 将 `main` 分支的 `env/nginx.conf` 添加到自己的 Nginx 内，如需修改路径自行修改，把 `front` 分支代码丢进去。对着路径将前端分支代码放入。启动 Nginx。配置即：

   ```nginx
   server {
       listen       80;
       server_name  www.easymall.com;
       location /products{
           proxy_pass	http://127.0.0.1:8090/products;
       }      
       location /user{
           proxy_pass	http://127.0.0.1:8090/user;
       }
       location /{
           root easymall-static;
           index index.html;
       }
   }
   server {
       listen		80;
       server_name	image.easymall.com;
       location / {
           root easymall_image;
       }
   }
   ```

4. 如本地运行，自行将 `hosts` 添加 `easymall.com`。

