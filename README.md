# CS-320---software-test-automation
Java-based unit testing and QA projects using JUnit 5, built for CS-320 Software Test Automation and QA at SNHU
# CS-320 Software Test Automation and QA

Java-based unit testing and QA projects using JUnit 5, built for CS-320 Software Test Automation and QA at SNHU.

## Artifacts
- **Contact Service** (Contact.java, ContactService.java, ContactTest.java, ContactServiceTest.java) — Unit tested Java service from Project One
- **CS 320 Mod 7.pdf** — Summary and Reflections Report from Project Two

## Reflection

**How can I ensure that my code, program, or software is functional and secure?**
The most reliable way I found is to write tests that directly target the requirements — not just happy paths, but edge cases and invalid inputs too. In this course, that meant writing JUnit tests that verified boundary conditions like null values, strings exceeding the max length, and duplicate IDs. Running coverage reports in Eclipse helped me confirm I was actually exercising the code I thought I was. Functional and secure software does not happen by accident; it comes from being deliberate about what you test and why.

**How do I interpret user needs and incorporate them into a program?**
User needs have to be translated into concrete, testable requirements before any code gets written. In the Contact, Task, and Appointment services, the requirements told me exactly what constraints each field needed — max lengths, non-null rules, immutable fields — and my job was to make sure the code enforced those and the tests confirmed it. If a requirement was unclear, the safest move was to treat it strictly rather than assume flexibility that was never granted.

**How do I approach designing software?**
I start small and build outward. For each service in this course, I built the data object first, made sure it handled its own validation, then layered the service on top of it, and wrote tests alongside each piece rather than at the end. That incremental approach made debugging much easier because there was never a massive block of untested code to sort through. Testing is not a final step — it is part of the design process from the beginning.
