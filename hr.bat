call mvn -B -s settings.xml -DskipTests=true clean package
call java -Dspring.profiles.active="datajpa,heroku" -DDATABASE_URL="postgres://postgres:password@localhost:5432/restoraunts" -jar target/dependency/webapp-runner.jar target/*.war
