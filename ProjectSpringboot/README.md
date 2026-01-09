#### 1. Bảo vệ Endpoint Là thêm Token vào các API để client có thể lấy

#### 2. Skill endpoint khong co delete skill vi bi loi, thì ta xóa job thì xóa cả skill những xóa skill thì job nó lỗi

#### 3. Docker-compose

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

  docker build: build image
  -t project-springboot: đặt tên image

  .: dùng Dockerfile trong thư mục hiện tại

  docker build -t project-springboot .

  ```

- Run docker container từ image:

  ```text
  docker run -d -p 8080:80 <ten-image>

  docker run -d -p 8080:8080 --name springboot-app project-springboot

  -d: chạy nền (detached)

  -p 8080:8080: map port

  máy bạn: localhost:8080

  container: 8080

  --name springboot-app: đặt tên container

  ```

- Build từ docker-compose and run application:

  ```text
  # v volume
  docker-compose down -v
  # build
  docker-compose up -d --build
  ```

- Build từ docker-compose and run application:

```text
    docker exec -it mysqldb mysql -u root -p

    docker exec: chạy lệnh bên trong docker đang chạy
    -it : để dùng tương tác như show database, show tables;
    mysqldb là tên container
    mysql -u root -p: để vào MySQL shell
```

- See database:

```text
    SHOW DATABASES;
    USE jobsearch;
    SHOW TABLES;
    SELECT * FROM ten_bang;
```

- off container:

```text
    docker stop springbootapp
    docker stop mysqldb
```

- stop container vs docker-compose.yml 
```text
    docker compose stop

```
- Dừng + xoá container + xoá volume (xoá data MySQL) 
```text
    docker compose down -v
```

- Xoá docker image vs docker container 
```text
    docker rmi <name_docker_image>
    docker rm <name_docker_container>
```

- đẩy lên docker hub  
```text
    docker login 

    docker tag projectspringboot-spring-boot-app baoqp19/  projectspringboot-spring-boot-app:1.0

    docker images

    docker push baoqp19/projectspringboot-spring-boot-app:1.0
```
