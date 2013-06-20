# IronMan
A project focused on testing and analyzing application performance.

# Performance Statistics (before caching)

## Loading of Listings (without paging)
### http://localhost:8080/ironman/api/v1/listings?page=1&size=10&pf=dateCreated
The above query took 2252 ms

### http://localhost:8080/ironman/api/v1/listings?page=1&size=20&pf=dateCreated
The above query took 2247 ms

### http://localhost:8080/ironman/api/v1/listings?page=1&size=30&pf=dateCreated
The above query took 2254 ms

### http://localhost:8080/ironman/api/v1/listings?page=1&size=40&pf=dateCreated
The above query took 2270 ms

### http://localhost:8080/ironman/api/v1/listings?page=1&size=50&pf=dateCreated
The above query took 2330 ms

## Loading of listings with Paging
### http://localhost:8080/ironman/api/v1/listings?page=2&size=50&pf=dateCreated
The above query took 2325 ms

### http://localhost:8080/ironman/api/v1/listings?page=3&size=50&pf=dateCreated
The above query took 2345 ms

