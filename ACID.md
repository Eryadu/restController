ACID properties, short for Atomicity, Consistency, Isolation, and Durability, are a set of fundamental principles 
that ensure reliable and secure database transactions. They guarantee that data remains accurate, consistent, and 
recoverable, even in the face of errors or system failures.
Here's a breakdown of each property:

1. Atomicity:
A transaction is treated as an indivisible unit. Either all operations within a transaction are completed 
successfully, or none of them are. If any part of the transaction fails, the entire transaction is rolled back, 
ensuring the database remains in a consistent state.

2. Consistency:
Transactions maintain the database's integrity by ensuring that all operations adhere to predefined rules and 
constraints (e.g., data type, format, referential integrity). This means that the database remains in a valid state
after a transaction, regardless of whether it succeeds or fails.

3. Isolation:
Transactions operate independently of each other, preventing concurrent transactions from interfering or corrupting
each other's data. This ensures that each transaction sees a consistent view of the database, even if other 
transactions are running concurrently.

4. Durability:
Once a transaction is committed (successfully completed), its changes are permanently saved to the database and are 
guaranteed to be preserved, even in the event of system crashes or failures. This ensures that data is not lost due 
to unexpected interruptions. 
