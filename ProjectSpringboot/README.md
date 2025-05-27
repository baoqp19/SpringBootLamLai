#### 1. Bảo vệ Endpoint Là thêm Token vào các API để client có thể lấy 


#### 2. Skill endpoint khong co delete skill vi bi loi, thì ta xóa job thì xóa cả skill những xóa skill thì job nó lỗi 






#### 1. Docker-compose 

- Xóa tất cả container chạy theo compose:
    ```text
    docker-compose down
    ```

- Khởi động lại container đã build: 
    ```text
    # Chạy container đã build 
    docker-compose up -d  
    # Build lại và chạy container 
    docker-compose up -d --build 
    ```

- Build docker image từ dockerfile : 
    ```text
    docker build -t <tên-image>:<tag> <đường-dẫn-tới-Dockerfile>
    ```

- Run docker container từ image:  
    ```text
    docker run -d -p 8080:80 <ten-image>
    ```

- Build từ docker-compose and run application:   
    ```text 
    # v volume 
    docker-compose down -v 
    # build 
    docker-compose up -d --build 
    ```

