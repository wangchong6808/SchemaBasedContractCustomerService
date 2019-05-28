# SchemaBasedContractCustomerService

docker run --rm   -v $(pwd):/opt/app -w /opt/app -u root gradle:4.8-jdk8-alpine gradle clean bootRepackage

docker build -t chong01:5000/schema-based-contract-customerservice:1.0 .
docker login -u admin -p admin123 chong01:5000
docker push chong01:5000/schema-based-contract-customerservice:1.0