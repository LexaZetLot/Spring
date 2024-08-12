FROM mysql:8.0.33-oracle

ENV MYSQL_ROOT_PASSWORD=mypass

ENV MYSQL_USER=user
ENV MYSQL_PASSWORD=password
ENV MYSQL_DATABASE=db_jdbc

COPY ./scripts/ /docker-entrypoint-initdb.d/

EXPOSE 3306