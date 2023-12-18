docker buildx build \
--platform linux/amd64 \
-f./Dockerfile \
-t jacksonrising/sonata-api:1.0 .

docker run -p 8080:8108 \
--name sonata-api \
-d jacksonrising/sonata-api:1.0
