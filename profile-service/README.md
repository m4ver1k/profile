#Decision Records
## `AboutMe` as separate Table
- Considering max size of field is 5000 chars we can store separately and it won't cause latency (disk seek) or on wiret to just retrieve the profile.
- We can also load AboutMe async with a separate API.
- If/when required can use full text to search against `AboutMe` content.
> Even after considering these don't see a pressing need at this moment, and following KISS and YAGNI going with a simple approach. 