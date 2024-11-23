CREATE TABLE pet
	(pet_ID					INT							AUTO_INCREMENT			PRIMARY KEY,
	 pet_name				VARCHAR(30)											NOT NULL,
     breed					VARCHAR(30)											NOT NULL,
     species				VARCHAR(30)											NOT NULL,
     color					VARCHAR(30)											NOT NULL,
     age					INT													NOT NULL,
     sex					ENUM('male', 'female')								NOT NULL,
     arrival_date			DATE												NOT NULL,
     vaccination_status		ENUM('yes', 'no')									DEFAULT 'no' NOT NULL,
     spayed_neutered		ENUM('yes', 'no')									DEFAULT 'no' NOT NULL,
     training_level			ENUM('none', 'basic', 'intermediate', 'advanced') 	DEFAULT 'none' NOT NULL,
	 adoption_status		ENUM('available', 'adopted', 'returned')			DEFAULT 'available' NOT NULL
 );
 
CREATE TABLE adopter (
    adopter_id 				INT							AUTO_INCREMENT 		PRIMARY KEY,
    adopter_type 			ENUM('adopter', 'returnee', 'rescuer') 			DEFAULT 'adopter' 	NOT NULL,
    first_name 				VARCHAR(25) 									NOT NULL,
    last_name 				VARCHAR(25) 									NOT NULL,
    age 					INT 											NOT NULL,
    sex					ENUM('male', 'female') 								NOT NULL,
    pet_count 				INT 											DEFAULT 0 NOT NULL,
    address 				VARCHAR(255)									NOT NULL,
    income_level 			ENUM('low', 'middle', 'high') 					DEFAULT 'middle' NOT NULL,
    contact_number			VARCHAR(20),
    civil_status 			ENUM('single', 'married') 						DEFAULT 'single',
    reason 					TEXT
);

CREATE TABLE employee (
    employee_id 			INT 						AUTO_INCREMENT		PRIMARY KEY,
    first_name 				VARCHAR(25) 									NOT NULL,
    last_name 				VARCHAR(25) 									NOT NULL,
    sex						ENUM('male', 'female') 							NOT NULL,
    age						INT												NOT NULL,
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

-- INSERT VALUES
-- PET
INSERT INTO pet (pet_name, breed, species, color, age, sex, arrival_date, vaccination_status, spayed_neutered, training_level, adoption_status) 
VALUES	('Bella', 'Labrador Retriever', 'dog', 'Yellow', 3, 'female', '2024-01-10', 'yes', 'yes', 'basic', 'available'),
		('Max', 'German Shepherd', 'dog', 'Black', 4, 'male', '2024-02-15', 'yes', 'yes', 'advanced', 'adopted'),
		('Luna', 'Persian', 'cat', 'White', 2, 'female', '2024-03-12', 'yes', 'no', 'none', 'available'),
		('Charlie', 'Beagle', 'dog', 'Tricolor', 1, 'male', '2024-04-05', 'no', 'no', 'none', 'available'),
		('Milo', 'Siamese', 'cat', 'Cream', 2, 'male', '2024-05-08', 'yes', 'yes', 'intermediate', 'available'),
		('Lucy', 'Golden Retriever', 'dog', 'Golden', 5, 'female', '2024-06-11', 'yes', 'yes', 'advanced', 'returned'),
		('Daisy', 'Cockatiel', 'bird', 'Yellow', 1, 'female', '2024-07-01', 'yes', 'no', 'none', 'available'),
		('Bailey', 'Cocker Spaniel', 'cat', 'Brown', 3, 'male', '2024-07-20', 'yes', 'no', 'basic', 'adopted'),
		('Rocky', 'Bullcat', 'cat', 'Brindle', 4, 'male', '2024-08-02', 'yes', 'yes', 'advanced', 'available'),
		('Molly', 'Bullcat', 'cat', 'Gray', 1, 'female', '2024-08-18', 'no', 'no', 'none', 'available'),
		('Chloe', 'Maine Coon', 'cat', 'Brown Tabby', 2, 'female', '2024-09-04', 'yes', 'yes', 'intermediate', 'adopted'),
		('Zoe', 'Parrot', 'bird', 'Green', 3, 'female', '2024-09-10', 'yes', 'no', 'none', 'available'),
		('Buddy', 'Husky', 'dog', 'Gray and White', 2, 'male', '2024-09-25', 'yes', 'yes', 'basic', 'available'),
		('Coco', 'Shih Tzu', 'dog', 'White and Black', 1, 'female', '2024-10-05', 'no', 'no', 'none', 'available'),
		('Lily', 'Ragdoll', 'cat', 'Seal Point', 3, 'female', '2024-10-15', 'yes', 'yes', 'advanced', 'available'),
		('Toby', 'Dachshund', 'dog', 'Black and Tan', 5, 'male', '2024-10-20', 'yes', 'yes', 'intermediate', 'returned'),
		('Simba', 'Bengal', 'cat', 'Spotted', 2, 'male', '2024-11-01', 'yes', 'no', 'basic', 'available'),
		('Rosie', 'Canary', 'bird', 'Yellow', 1, 'female', '2024-11-10', 'yes', 'no', 'none', 'available'),
		('Oscar', 'Chow Chow', 'cat', 'Red', 4, 'male', '2024-11-15', 'yes', 'yes', 'advanced', 'adopted'),
		('Ruby', 'Scottish Fold', 'dog', 'Gray', 3, 'female', '2024-11-18', 'yes', 'yes', 'none', 'available'),
		('Thor', 'Alaskan Malamute', 'dog', 'Black and White', 3, 'male', '2024-01-15', 'yes', 'yes', 'advanced', 'available'),
		('Oreo', 'Boston Terrier', 'cat', 'Black and White', 2, 'male', '2024-01-20', 'no', 'no', 'none', 'available'),
		('Trixie', 'Yorkshire Terrier', 'cat', 'Brown and Black', 1, 'female', '2024-02-01', 'yes', 'no', 'none', 'adopted'),
		('Gizmo', 'Cockatoo', 'bird', 'White', 5, 'male', '2024-02-10', 'yes', 'no', 'none', 'available'),
		('Pepper', 'Tuxedo', 'cat', 'Black and White', 3, 'male', '2024-02-20', 'yes', 'yes', 'basic', 'available'),
		('Bandit', 'Ferret', 'dog', 'White and Brown', 2, 'male', '2024-03-01', 'yes', 'no', 'none', 'available'),
		('Nala', 'Angora', 'dog', 'White', 1, 'female', '2024-03-05', 'yes', 'no', 'none', 'available'),
		('Rex', 'German Shepherd', 'dog', 'Black and Tan', 6, 'male', '2024-03-10', 'yes', 'yes', 'intermediate', 'adopted'),
		('Skye', 'Blue Heeler', 'cat', 'Blue', 4, 'female', '2024-03-15', 'yes', 'yes', 'advanced', 'returned'),
		('Blaze', 'Tabby', 'cat', 'Orange', 2, 'male', '2024-03-20', 'yes', 'no', 'none', 'available'),
		('Misty', 'Lovebird', 'bird', 'Peach and Green', 1, 'female', '2024-03-25', 'yes', 'no', 'none', 'available'),
		('Tank', 'English Bullcat', 'cat', 'Fawn', 4, 'male', '2024-04-01', 'yes', 'yes', 'basic', 'available'),
		('Ash', 'Siberian', 'dog', 'Gray', 3, 'male', '2024-04-10', 'yes', 'yes', 'intermediate', 'available'),
		('Sparky', 'Jack Russell Terrier', 'dog', 'White and Tan', 2, 'male', '2024-04-15', 'yes', 'no', 'none', 'available'),
		('Lulu', 'Pug', 'dog', 'Black', 5, 'female', '2024-04-20', 'yes', 'yes', 'none', 'adopted'),
		('Fido', 'Golden Retriever', 'dog', 'Golden', 1, 'male', '2024-04-25', 'no', 'no', 'none', 'available'),
		('Poppy', 'Persian', 'cat', 'Cream', 4, 'female', '2024-05-01', 'yes', 'yes', 'intermediate', 'returned'),
		('Bruno', 'Boxer', 'cat', 'Brindle', 6, 'male', '2024-05-10', 'yes', 'yes', 'advanced', 'available'),
		('Jasper', 'Russian Blue', 'cat', 'Gray', 3, 'male', '2024-05-15', 'yes', 'yes', 'basic', 'adopted'),
		('Ivy', 'Amazon Parrot', 'bird', 'Green', 5, 'female', '2024-05-20', 'yes', 'no', 'none', 'available'),
		('Finn', 'Border Collie', 'dog', 'Black and White', 2, 'male', '2024-06-01', 'yes', 'yes', 'advanced', 'available'),
		('Holly', 'Havanese', 'dog', 'White', 1, 'female', '2024-06-05', 'yes', 'no', 'none', 'available'),
		('Shadow', 'Mixed Breed', 'dog', 'Black', 4, 'male', '2024-06-10', 'yes', 'yes', 'intermediate', 'adopted'),
		('Bolt', 'Greyhound', 'dog', 'Gray', 3, 'male', '2024-06-15', 'yes', 'yes', 'none', 'returned'),
		('Pumpkin', 'Tabby', 'cat', 'Orange', 2, 'female', '2024-06-20', 'yes', 'no', 'none', 'available'),
		('Smokey', 'Domestic Shorthair', 'cat', 'Gray', 4, 'male', '2024-07-01', 'yes', 'no', 'none', 'available'),
		('Sunny', 'Canary', 'bird', 'Yellow', 1, 'female', '2024-07-05', 'yes', 'no', 'none', 'available'),
		('Buster', 'Great Dane', 'dog', 'Black', 5, 'male', '2024-07-10', 'yes', 'yes', 'intermediate', 'adopted'),
		('Penny', 'Mini Lop', 'dog', 'Brown', 2, 'female', '2024-07-15', 'yes', 'no', 'none', 'available'),
		('Ranger', 'Australian cattle dog', 'dog', 'Blue', 3, 'male', '2024-07-20', 'yes', 'yes', 'advanced', 'available'),
		('Willow', 'Cockapoo', 'dog', 'White and Brown', 1, 'female', '2024-07-25', 'yes', 'no', 'basic', 'available');

-- ADOPTER
INSERT INTO adopter (adopter_type, first_name, last_name, age, sex, pet_count, address, income_level, contact_number, civil_status, reason)
VALUES	('adopter', 'John', 'Doe', 32, 'male', 1, '123 Elm Street, Springfield', 'middle', '555-1234', 'married', 'Looking for a companion'),
		('adopter', 'Jane', 'Smith', 28, 'female', 0, '456 Oak Avenue, Greenville', 'high', '555-5678', 'single', 'Love for animals'),
		('rescuer', 'Emily', 'Clark', 35, 'female', 3, '789 Maple Lane, Cedar City', 'low', '555-8765', 'married', 'Rescuing stray animals'),
		('adopter', 'Michael', 'Brown', 40, 'male', 2, '101 Pine Road, Riverdale', 'middle', '555-4321', 'married', 'Providing a loving home'),
		('returnee', 'Sarah', 'Johnson', 30, 'female', 1, '202 Birch Drive, Sunnyvale', 'middle', '555-6789', 'single', 'Returning due to relocation'),
		('adopter', 'Chris', 'Davis', 22, 'male', 0, '303 Aspen Court, Greenwood', 'low', '555-2468', 'single', 'First-time pet owner'),
		('adopter', 'Laura', 'Martinez', 50, 'female', 4, '404 Willow Way, Bridgeport', 'high', '555-1357', 'married', 'Experienced pet owner'),
		('rescuer', 'Tom', 'Garcia', 38, 'male', 5, '505 Poplar Street, Bayside', 'middle', '555-9753', 'married', 'Rehabilitating abandoned pets'),
		('adopter', 'Anna', 'Lee', 26, 'female', 0, '606 Cypress Avenue, Hillcrest', 'middle', '555-8642', 'single', 'Animal lover'),
		('adopter', 'Robert', 'Wilson', 45, 'male', 2, '707 Magnolia Boulevard, Seaside', 'middle', '555-7531', 'married', 'Family pet'),
		('adopter', 'Sophia', 'Taylor', 29, 'female', 0, '808 Dogwood Terrace, Fairview', 'middle', '555-3698', 'single', 'Looking for companionship'),
		('rescuer', 'Daniel', 'Moore', 41, 'male', 3, '909 Cherry Hill, Lakeside', 'middle', '555-2587', 'married', 'Dedicated rescuer'),
		('adopter', 'Olivia', 'Anderson', 33, 'female', 1, '111 Juniper Place, Windy Ridge', 'high', '555-8523', 'married', 'Lifelong animal enthusiast'),
		('adopter', 'James', 'Hernandez', 36, 'male', 2, '222 Spruce View, Forest Town', 'middle', '555-1479', 'married', 'Adding a furry friend'),
		('adopter', 'Isabella', 'Walker', 24, 'female', 0, '333 Alder Lane, Mountain View', 'middle', '555-6547', 'single', 'Adopting my first pet'),
		('returnee', 'Liam', 'Lopez', 31, 'male', 1, '444 Redwood Street, Green Valley', 'middle', '555-3214', 'married', 'Returning after job change'),
		('adopter', 'Mia', 'King', 27, 'female', 0, '555 Cedar Ridge, Clearfield', 'low', '555-7896', 'single', 'Excited for a new friend'),
		('adopter', 'Ethan', 'Scott', 39, 'male', 2, '666 Pine Hollow, Oak Grove', 'middle', '555-3697', 'married', 'Family-friendly addition'),
		('adopter', 'Charlotte', 'Adams', 48, 'female', 3, '777 Maplewood Avenue, Pleasantville', 'high', '555-8521', 'married', 'Animal lover with experience'),
		('rescuer', 'Jack', 'Baker', 43, 'male', 4, '888 Aspen Valley, Meadowbrook', 'middle', '555-9513', 'married', 'Committed to saving lives');
        
-- EMPLOYEE
INSERT INTO employee (first_name, last_name, sex, age, employee_role, years_of_experience, salary, number_of_hours_worked, date_worked, notes)
VALUES	('Alice', 'Johnson', 'female', 30, 'Veterinarian', 5, 60000.00, 160, '2024-10-01', 'Skilled in animal surgery'),
		('Bob', 'Smith', 'male', 35, 'Animal Trainer', 8, 45000.00, 180, '2024-10-02', 'Specializes in obedience training'),
		('Carol', 'Davis', 'female', 28, 'Shelter Manager', 4, 50000.00, 170, '2024-10-03', 'Efficient in shelter management'),
		('David', 'Martinez', 'male', 40, 'Adoption Coordinator', 10, 55000.00, 160, '2024-10-04', 'Expert in pairing adopters with pets'),
		('Emma', 'Brown', 'female', 26, 'Veterinary Assistant', 3, 35000.00, 150, '2024-10-05', 'Experience in animal care'),
		('Frank', 'Wilson', 'male', 38, 'Animal Behaviorist', 7, 48000.00, 165, '2024-10-06', 'Focus on rehabilitation of abused animals'),
		('Grace', 'Hernandez', 'female', 32, 'Kennel Attendant', 5, 32000.00, 170, '2024-10-07', 'Maintains cleanliness and order in kennels'),
		('Henry', 'Moore', 'male', 29, 'Volunteer Coordinator', 6, 40000.00, 160, '2024-10-08', 'Recruits and trains volunteers'),
		('Isabella', 'Taylor', 'female', 34, 'Pet Nutritionist', 9, 47000.00, 160, '2024-10-09', 'Creates diet plans for animals'),
		('Jack', 'Anderson', 'male', 36, 'Shelter Veterinarian', 10, 65000.00, 160, '2024-10-10', 'Highly experienced in complex treatments'),
		('Karen', 'Lopez', 'female', 27, 'Pet Groomer', 4, 34000.00, 150, '2024-10-11', 'Specializes in grooming for all breeds'),
		('Luke', 'King', 'male', 31, 'Animal Control Officer', 6, 42000.00, 170, '2024-10-12', 'Handles rescue and safety operations'),
		('Mia', 'Adams', 'female', 24, 'Receptionist', 2, 30000.00, 160, '2024-10-13', 'Manages front desk operations'),
		('Nathan', 'Baker', 'male', 42, 'Operations Manager', 12, 70000.00, 160, '2024-10-14', 'Oversees all shelter activities'),
		('Olivia', 'Scott', 'female', 29, 'Animal Foster Coordinator', 5, 38000.00, 160, '2024-10-15', 'Coordinates foster care programs');

-- ADOPTION
INSERT INTO adoption (pet_id, adopter_id, employee_id, adoption_date, adoption_fee)
VALUES	(1, 1, 1, '2024-11-18', 2500.00),
		(2, 2, 2, '2024-11-18', 1900.00),
		(4, 3, 3, '2024-11-18', 2200.00),
		(7, 4, 4, '2024-11-18', 1700.00),
		(8, 5, 5, '2024-11-18', 2600.00),
		(11, 6, 6, '2024-11-18', 2000.00),
		(13, 7, 7, '2024-11-18', 2300.00),
		(14, 8, 8, '2024-11-18', 1800.00),
		(16, 9, 9, '2024-11-18', 2400.00),
		(19, 10, 10, '2024-11-18', 2100.00);