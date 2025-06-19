
// HQL , JPQL :
// SQL : native query

-- We write query in the term of Java Objects in HQL, JPQL, not in the term of table column name.
-- we use entity name instead of table name, and property name instead of column name.

-- If we use @RequestBody, it returned the data in JSoN or XML format, to receive this type of data we need object.
   rather than property name. i.e. we use StudentFirstName studentFirstName(Class-Object) as object instead of String firstName
-- if we want to pass the String firstName then pass data as Text in @RequestBody
-- @RequestBody is more secure than @PathVariable or @RequestParam

-- In @Query, nativeQuery by default is false, we need to mention if wanted to use SQL query
-- @GeneratedValue(strategy = GenerationType.Auto) ?
-- Always check ddl-auto property if you want to make any structural change in table 
-- Table, Sequence, Identity -> responsibility goes to database
-- need to understand AUTO :-> who generate Auto ID? JVM, Spring ?
-- UUID ?
