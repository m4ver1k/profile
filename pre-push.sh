set -e

cd profile-service 
./gradlew test
 
cd ..
cd profile-web
npm run test