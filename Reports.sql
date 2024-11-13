-- ADOPTION HISTORY REPORT
SELECT 		YEAR(a.adoption_date) 	AS adoption_year,
			MONTH(a.adoption_date) 	AS adoption_month,
			COUNT(a.adoption_id) 	AS total_adoptions,
			GROUP_CONCAT(DISTINCT DATE(a.adoption_date) ORDER BY a.adoption_date) AS adoption_dates,
			GROUP_CONCAT(DISTINCT CONCAT(ad.first_name, ' ', ad.last_name) ORDER BY a.adoption_date) AS adopters
FROM 		adoption a
JOIN 		adopter ad ON a.adopter_id = ad.adopter_id
WHERE 		YEAR(a.adoption_date) = 2024  -- Replace with the desired year
GROUP BY 	adoption_year, adoption_month
ORDER BY 	adoption_year DESC, adoption_month DESC;

-- EMPLOYEE ADOPTION REPORT
SELECT 		e.employee_id,
			e.first_name 		AS employee_first_name,
			e.last_name 		AS employee_last_name,
			e.years_of_experience,
			p.pet_name 			AS pet_name,
			p.breed 			AS pet_breed,
			p.species 			AS pet_species,
			p.adoption_status 	AS pet_adoption_status
FROM 		adoption a	JOIN 	pet p 		ON a.pet_id = p.pet_id
						JOIN 	employee e 	ON a.employee_id = e.employee_id
WHERE 		p.breed = 'Beagle' AND -- Replace with the desired breed
			p.species = 'Dog' -- Replace with the desired species
ORDER BY 	e.employee_id, p.adoption_status DESC;

-- ADOPTION TRENDS REPORT
SELECT 		YEAR(a.adoption_date) 	AS adoption_year,
			MONTH(a.adoption_date) 	AS adoption_month,
            p.species 				AS pet_species,
			p.adoption_status 		AS pet_adoption_status,
			ad.income_level 		AS adopter_income_level,
			a.adoption_fee 			AS adoption_fee,
			COUNT(a.adoption_id) 	AS total_adoptions
FROM 		adoption a	JOIN	pet p 		ON a.pet_id = p.pet_id
						JOIN 	adopter ad 	ON a.adopter_id = ad.adopter_id
WHERE 		YEAR(a.adoption_date) = 2024 AND -- Replace with the desired year
			MONTH(a.adoption_date) = 5  -- Replace with the desired month
GROUP BY 	adoption_year, adoption_month, pet_species, pet_adoption_status, adopter_income_level
ORDER BY 	adoption_year DESC, adoption_month DESC, total_adoptions DESC;

-- ADOPTION REVENUE REPORT
SELECT 		YEAR(a.adoption_date) 																	AS adoption_year,
			MONTH(a.adoption_date) 																	AS adoption_month,
			SUM(a.adoption_fee)																		AS total_adoption_revenue,
			GROUP_CONCAT(DISTINCT DATE(a.adoption_date) ORDER BY a.adoption_date) 					AS adoption_dates,
			GROUP_CONCAT(DISTINCT CONCAT(e.first_name, ' ', e.last_name) ORDER BY a.adoption_date) 	AS employees,
			GROUP_CONCAT(DISTINCT e.salary ORDER BY a.adoption_date) 								AS employee_salaries
FROM 		adoption a	JOIN 	employee e 	ON a.employee_id = e.employee_id
WHERE 		YEAR(a.adoption_date) = 2024  -- Replace with the desired year
GROUP BY 	adoption_year, adoption_month
ORDER BY 	adoption_year DESC, adoption_month DESC;
