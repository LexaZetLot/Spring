FROM mysql:8.0.33-oracle

ENV MYSQL_ROOT_PASSWORD=mypass

ENV MYSQL_USER=prospring5
ENV MYSQL_PASSWORD=prospring5
ENV MYSQL_DATABASE=musicdb

COPY ./scripts/ /docker-entrypoint-initdb.d/

EXPOSE 3306