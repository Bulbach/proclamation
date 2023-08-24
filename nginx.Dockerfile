FROM nginx:1.21-alpine

RUN rm /etc/nginx/conf.d/default.conf
COPY nginx.conf /etc/nginx/conf.d
COPY rabota-germaniya.eu.certificate.pem /etc/ssl/bundle.crt
COPY rabota-germaniya.eu.key.txt /etc/ssl/vash_domen.key
