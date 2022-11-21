FROM node:latest as angular
WORKDIR /app
COPY package.json /app
RUN npm install --silent
COPY . .
RUN npm run build

FROM nginx:alpine
VOLUME /var/cache/nginx
COPY --from=angular app/dist/programador-front /usr/share/nginx/html
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
