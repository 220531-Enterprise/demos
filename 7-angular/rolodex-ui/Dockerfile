# declare node as the base image so we can run npm install
FROM node:14.15.0 as builder

# this is the working directory the container will be instructed to work with
WORKDIR /usr/src/app

COPY package.json package-lock.json ./

RUN npm install

COPY . .

# by this point we have all the source code and dependencies to build the dist folder
RUN npm run build --prod

# pass off the static resources to a web server - Nginx
FROM nginx:1.15.8-alpine

# pass the distributable artifact to Nginx to host
COPY --from=builder /usr/src/app/dist/rolodex-ui/ /usr/share/nginx/html

# To run the container, after building the image,
# run docker run -p 8080:80 <name-of-image:version>
# (80 is the default nginx port)
