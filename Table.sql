CREATE TABLE pet
	(pet_ID					INT							AUTO_INCREMENT		PRIMARY KEY,
	 pet_name				VARCHAR(30)										NOT NULL,
     breed					VARCHAR(30)										NOT NULL,
     species				VARCHAR(30)										NOT NULL,
     color					VARCHAR(30)										NOT NULL,
     age					INT												NOT NULL,
     sex					ENUM('male', 'female') 							NOT NULL,
     arrival_date			DATE											NOT NULL,
     vaccination_status		ENUM('yes', 'no')								DEFAULT 'no' NOT NULL,
     spayed_neutered		ENUM('yes', 'no')								DEFAULT 'no' NOT NULL,
     training_level			VARCHAR(30)										NOT NULL,
	 adoption_status		ENUM('available', 'adopted', 'returned')		DEFAULT 'available' NOT NULL
 );
 
CREATE TABLE adopter (
    adopter_id 				INT							AUTO_INCREMENT 		PRIMARY KEY,
    adopter_type 			ENUM('adopter', 'returnee', 'rescuer') 			DEFAULT 'adopter' 	NOT NULL,
    first_name 				VARCHAR(25) 									NOT NULL,
    last_name 				VARCHAR(25) 									NOT NULL,
    age 					INT 											NOT NULL,
    pet_count 				INT 											DEFAULT 0 NOT NULL,
    address 				VARCHAR(255)									NOT NULL,
    income_level 			ENUM('low', 'medium', 'high') 					DEFAULT 'medium' NOT NULL,
    contact_number			VARCHAR(20),
    civil_status 			ENUM('single', 'married', 'divorced') 			DEFAULT 'single',
    reason 					TEXT
);

CREATE TABLE employee (
    employee_id 			INT 						AUTO_INCREMENT		PRIMARY KEY,
    first_name 				VARCHAR(25) 									NOT NULL,
    last_name 				VARCHAR(25) 									NOT NULL,
    employee_role			VARCHAR(30) 									NOT NULL,
    years_of_experience 	INT												NOT NULL,
    salary 					DECIMAL(10, 2)									NOT NULL,
    number_of_hours_worked	INT												NOT NULL,
    date_worked 			DATE 											NOT NULL,
    notes 					TEXT
);

CREATE TABLE adoption (
    adoption_id				INT 						AUTO_INCREMENT 		PRIMARY KEY,
    pet_id 					INT 											NOT NULL,
    adopter_id 				INT 											NOT NULL,
    employee_id 			INT 											NOT NULL,
    adoption_date 			DATE 											NOT NULL,
    adoption_fee 			DECIMAL(10, 2) 									NOT NULL,
    FOREIGN KEY (pet_id) REFERENCES pet(pet_id) ON DELETE CASCADE,
    FOREIGN KEY (adopter_id) REFERENCES adopter(adopter_id) ON DELETE CASCADE,
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id) ON DELETE CASCADE
);