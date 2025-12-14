CREATE TABLE IF NOT EXISTS "customer_role" (
	"customer_id" UUID NOT NULL REFERENCES "customer"("id"),
	"role_id" UUID NOT NULL REFERENCES "role"("id")
);
