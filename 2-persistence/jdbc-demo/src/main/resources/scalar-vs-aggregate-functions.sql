/**
SQL has 2 types of built in functions: Scalar or Aggregate

SCALAR FUNCTION:
perform ONE thing to every value in a column and return it (return multiple columns)

AGGREGATE FUNCTION:
return 1 value from an entire column
*/
SELECT * FROM "Invoice";

SELECT UPPER("BillingCity") FROM "Invoice";
SELECT lower("BillingCity") FROM "Invoice";

SELECT ascii("BillingCity") FROM "Invoice"; 

SELECT ascii(reverse("BillingCity"))
AS "last letter ascii value"
FROM "Invoice"; 

-- Resource for a ton of scalar functions
-- https://docs.actian.com/psql/psqlv13/index.html#page/sqlref%2Fscalarfunc.htm%23ww1138183

/**
 * Aggregate Function: returning ONE value
 */

SELECT * FROM "Invoice";
SELECT COUNT("Total") FROM "Invoice";

SELECT MAX("Total") FROM "Invoice";

SELECT AVG("Total") FROM "Invoice";

SELECT TRUNC(AVG("Total"), 2)FROM "Invoice";

