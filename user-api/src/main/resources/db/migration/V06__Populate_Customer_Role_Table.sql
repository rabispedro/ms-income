INSERT INTO "Customer_Role"("user_id", "role_id")
VALUES
	((SELECT id FROM "Customer" WHERE name LIKE 'Sistema'), (SELECT id FROM "Role" WHERE name LIKE 'ROLE_ADMINISTRATOR')),
	((SELECT id FROM "Customer" WHERE name LIKE 'Bob Marleio'), (SELECT id FROM "Role" WHERE name LIKE 'ROLE_DESIGNER')),
	((SELECT id FROM "Customer" WHERE name LIKE 'Bob Marleio'), (SELECT id FROM "Role" WHERE name LIKE 'ROLE_AGILIST')),
	((SELECT id FROM "Customer" WHERE name LIKE 'Maria das Neves'), (SELECT id FROM "Role" WHERE name LIKE 'ROLE_SOFTWARE_ENGINEER')),
	((SELECT id FROM "Customer" WHERE name LIKE 'Alex Wesker'), (SELECT id FROM "Role" WHERE name LIKE 'ROLE_PRODUCT_OWNER')),
	((SELECT id FROM "Customer" WHERE name LIKE 'Alex Wesker'), (SELECT id FROM "Role" WHERE name LIKE 'ROLE_DATA_ENGINEER')),
	((SELECT id FROM "Customer" WHERE name LIKE 'Alex Wesker'), (SELECT id FROM "Role" WHERE name LIKE 'ROLE_SOFTWARE_ENGINEER')),
	((SELECT id FROM "Customer" WHERE name LIKE 'Alex Wesker'), (SELECT id FROM "Role" WHERE name LIKE 'ROLE_QUALITY_ASSURANCER')),
	((SELECT id FROM "Customer" WHERE name LIKE 'Albert Trebla'), (SELECT id FROM "Role" WHERE name LIKE 'ROLE_QUALITY_ASSURANCER'));
