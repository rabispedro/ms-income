CREATE TABLE IF NOT EXISTS "Worker" (
	"id" UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
	"name" VARCHAR(50) NOT NULL,
	"daily_income" BIGINT NOT NULL
);
