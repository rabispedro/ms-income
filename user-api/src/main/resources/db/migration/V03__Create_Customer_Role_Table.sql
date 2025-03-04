CREATE TABLE IF NOT EXISTS "Customer_Role" (
	"user_id" UUID NOT NULL REFERENCES "Customer"("id"),
	"role_id" UUID NOT NULL REFERENCES "Role"("id")
);
