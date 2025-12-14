INSERT INTO "customer_role"("customer_id", "role_id")
VALUES
	((SELECT id FROM "customer" WHERE name LIKE 'Sistema'), (SELECT id FROM "role" WHERE name LIKE 'ROLE_ADMINISTRATOR')),
	((SELECT id FROM "customer" WHERE name LIKE 'Bob Marleio'), (SELECT id FROM "role" WHERE name LIKE 'ROLE_DESIGNER')),
	((SELECT id FROM "customer" WHERE name LIKE 'Bob Marleio'), (SELECT id FROM "role" WHERE name LIKE 'ROLE_AGILIST')),
	((SELECT id FROM "customer" WHERE name LIKE 'Maria das Neves'), (SELECT id FROM "role" WHERE name LIKE 'ROLE_SOFTWARE_ENGINEER')),
	((SELECT id FROM "customer" WHERE name LIKE 'Alex Wesker'), (SELECT id FROM "role" WHERE name LIKE 'ROLE_PRODUCT_OWNER')),
	((SELECT id FROM "customer" WHERE name LIKE 'Alex Wesker'), (SELECT id FROM "role" WHERE name LIKE 'ROLE_DATA_ENGINEER')),
	((SELECT id FROM "customer" WHERE name LIKE 'Alex Wesker'), (SELECT id FROM "role" WHERE name LIKE 'ROLE_SOFTWARE_ENGINEER')),
	((SELECT id FROM "customer" WHERE name LIKE 'Alex Wesker'), (SELECT id FROM "role" WHERE name LIKE 'ROLE_QUALITY_ASSURANCER')),
	((SELECT id FROM "customer" WHERE name LIKE 'Albert Trebla'), (SELECT id FROM "role" WHERE name LIKE 'ROLE_QUALITY_ASSURANCER'));
