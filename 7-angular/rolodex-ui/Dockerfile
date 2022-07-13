FROM node:14.15.0 As builder

WORKDIR /usr/src/app

COPY package.json package-lock.json ./

RUN npm install

COPY . .

RUN npm run build --prod

# pass off the static resources (everything in my dist folder)
# to a web server
FROM nginx:1.15.8-alpine

# we pass our ditributable artifact to Nginx to host
COPY --from=builder /usr/src/app/dist/rolodex-ui/ /usr/share/nginx/html

# To run the container, after building the image,
# run docker run -p 8080:80 <name-of-image:version>
# (80 is the default nginx port)
