# LoanCalculator

Steps to run the project - 

1) Clone the project from Github

 git clone https://github.com/AnupBhagwat7/LoanCalculator.git
 

2) Run the spring boot project using below maven command - 

mvn clean install spring-boot:run


3) Hit the webservice in POSTMAN tool 

http://localhost:8081/generate-plan

Input to Webservice:

{
"principal" : 2000000,
"interest" : 8.5,
"tenure" : 5,
"startDate": "2018-01-01T01:28:56.782Z"
}

Output of Webservice:

[
    {
        "month": 1,
        "date": "2018-01-01",
        "emi": 41033,
        "pricipal": 26866,
        "interest": 14167,
        "balance": 1973134
    },
    {
        "month": 2,
        "date": "2018-02-01",
        "emi": 41033,
        "pricipal": 27057,
        "interest": 13976,
        "balance": 1946077
    },
    Remaining months data
]
