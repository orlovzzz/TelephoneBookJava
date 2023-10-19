FROM mysql:8

ENV MYSQL_ROOT_PASSWORD = root
ENV MYSQL_DATABASE = number
ENV MYSQL_USER = user
ENV MYSQL_PASSWORD = password

COPY init.sql /docker-entrypoint-initdb.d/

CMD ["mysqld"]

EXPOSE 3306