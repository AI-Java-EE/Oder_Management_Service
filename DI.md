# Test default (Email via @Primary)

curl -X POST "http://localhost:8080/api/orders/1001"

# Test SMS (via @Qualifier + @Lazy)
curl -X POST "http://localhost:8080/api/orders/1002?sms=true"
