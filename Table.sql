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
    sex					ENUM('male', 'female') 								NOT NULL,
    pet_count 				INT 											DEFAULT 0 NOT NULL,
    address 				VARCHAR(255)									NOT NULL,
    income_level 			ENUM('low', 'medium', 'high') 					DEFAULT 'medium' NOT NULL,
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
INSERT INTO pet (pet_name, breed, species, color, age, sex, arrival_date, vaccination_status, spayed_neutered, training_level, adoption_status)
VALUES 	('Buddy', 	'Golden Retriever', 	'Dog', 	'Golden', 								3, 	 'male',   '2024-11-17',  'yes', 	    	  'yes', 		   'Intermediate',   'available'),
		('Luna',               'Siberian Husky',    'Dog',         'Gray and White',        2,   'female', '2024-11-15',  'yes',              'yes',           'Advanced',       'available'),
		('Milo',               'Persian Cat',       'Cat',         'White',                 4,   'male',   '2024-11-14',  'yes',              'no',            'Beginner',       'available'),
		('Bella',              'Labrador Retriever','Dog',         'Black',                 3,   'female', '2024-10-25',  'no',               'yes',           'Intermediate',   'adopted'),
		('Charlie',            'Maine Coon',        'Cat',         'Brown Tabby',           5,   'male',   '2024-09-30',  'yes',              'yes',           'Beginner',       'available'),
		('Daisy',              'Golden Retriever',  'Dog',         'Golden',                1,   'female', '2024-11-12',  'no',               'no',            'Beginner',       'returned'),
		('Oscar',              'Cockatiel',         'Bird',        'Yellow and Gray',       3,   'male',   '2024-10-20',  'yes',              'no',            'Beginner',       'available'),
		('Chloe',              'Ragdoll',           'Cat',         'Seal Point',            2,   'female', '2024-11-10',  'yes',              'yes',           'Intermediate',   'available'),
		('Max',                'Beagle',            'Dog',         'Tricolor',              4,   'male',   '2024-09-15',  'yes',              'no',            'Intermediate',   'adopted'),
		('Ruby',               'Cockapoo',          'Dog',         'Cream',                 3,   'female', '2024-11-05',  'yes',              'yes',           'Advanced',       'available'),
		('Jack',               'Abyssinian',        'Cat',         'Ruddy',                 6,   'male',   '2024-10-02',  'no',               'no',            'Beginner',       'available'),
		('Zoey',               'Shih Tzu',          'Dog',         'White and Brown',       5,   'female', '2024-08-30',  'yes',              'no',            'Intermediate',   'available'),
		('Rocky',              'German Shepherd',   'Dog',         'Black and Tan',         2,   'male',   '2024-11-06',  'yes',              'yes',           'Advanced',       'adopted'),
		('Ginger',             'Calico',            'Cat',         'Orange, White, Black',  1,   'female', '2024-11-17',  'no',               'no',            'Beginner',       'available'),
		('Shadow',             'Belgian Malinois',  'Dog',         'Brown and Black',       3,   'male',   '2024-11-11',  'yes',              'yes',           'Advanced',       'available'),
		('Sasha',              'Russian Blue',      'Cat',         'Gray',                  4,   'female', '2024-11-13',  'yes',              'no',            'Intermediate',   'returned'),
		('Buddy',              'Cocker Spaniel',    'Dog',         'Gold',                  6,   'male',   '2024-10-28',  'no',               'yes',           'Beginner',       'available'),
		('Nala',               'Bengal Cat',        'Cat',         'Spotted',               2,   'female', '2024-11-04',  'yes',              'yes',           'Advanced',       'available'),
		('Zeus',               'Great Dane',        'Dog',         'Blue',                  5,   'male',   '2024-09-12',  'yes',              'no',            'Intermediate',   'available'),
		('Mimi',               'Lovebird',          'Bird',        'Green and Peach',       3,   'female', '2024-11-16',  'no',               'no',            'Beginner',       'available'),
		('Max',         'Shih Tzu',     'Dog',    'Brown',     4,  'male',   '2024-10-01', 'yes', 'yes', 'basic',     'available'),
		('Luna',        'Persian',      'Cat',    'White',     3,  'female', '2024-09-15', 'yes', 'no',  'intermediate', 'available'),
		('Rocky',       'Husky',        'Dog',    'Gray',      2,  'male',   '2024-08-20', 'no',  'no',  'basic',     'available'),
		('Milo',        'Beagle',       'Dog',    'Tri-color', 5,  'male',   '2024-07-30', 'yes', 'yes', 'advanced',  'adopted'),
		('Bella',       'Tabby',        'Cat',    'Orange',    6,  'female', '2024-06-18', 'yes', 'yes', 'none',      'available'),
		('Charlie',     'Dalmatian',    'Dog',    'Spotted',   1,  'male',   '2024-05-22', 'no',  'yes', 'basic',     'available'),
		('Daisy',       'Poodle',       'Dog',    'Black',     3,  'female', '2024-04-10', 'yes', 'no',  'intermediate', 'adopted'),
		('Oliver',      'Sphynx',       'Cat',    'Pink',      4,  'male',   '2024-03-05', 'no',  'yes', 'none',      'available'),
		('Ruby',        'Labrador',     'Dog',    'Golden',    7,  'female', '2024-02-25', 'yes', 'no',  'advanced',  'returned'),
		('Oscar',       'German Shepherd', 'Dog', 'Black',    2,  'male',   '2024-01-15', 'yes', 'yes', 'intermediate', 'available'),
		('Shadow',      'Ragdoll',      'Cat',    'Gray',      3,  'male',   '2023-12-01', 'no',  'no',  'none',      'adopted'),
		('Coco',        'Chihuahua',    'Dog',    'Brown',     4,  'female', '2023-11-19', 'yes', 'yes', 'basic',     'available'),
		('Ginger',      'Calico',       'Cat',    'White',     5,  'female', '2023-10-29', 'yes', 'no',  'none',      'available'),
		('Leo',         'Maine Coon',   'Cat',    'Brown',     6,  'male',   '2023-09-25', 'no',  'no',  'advanced',  'available'),
		('Bruno',       'Bulldog',      'Dog',    'Brindle',   5,  'male',   '2023-08-20', 'yes', 'yes', 'none',      'adopted'),
		('Mochi',       'Scottish Fold','Cat',    'Cream',     1,  'female', '2023-07-18', 'yes', 'no',  'intermediate', 'available'),
		('Nala',        'Golden Retriever','Dog', 'Golden',   2,  'female', '2023-06-10', 'yes', 'yes', 'advanced',  'available'),
		('Loki',        'Abyssinian',   'Cat',    'Brown',     3,  'male',   '2023-05-01', 'no',  'yes', 'basic',     'returned'),
		('Hazel',       'Yorkshire Terrier','Dog','Black',    1,  'female', '2023-04-12', 'yes', 'yes', 'intermediate', 'available'),
		('Simba',       'Bengal',       'Cat',    'Orange',    4,  'male',   '2023-03-05', 'yes', 'no',  'none',      'adopted');

        
        
INSERT INTO adopter	(adopter_type,   first_name,    last_name,     age, sex,     pet_count, address,                income_level,   contact_number,    civil_status, reason)
VALUES	('adopter',      'Alice',       'Smith',       28, 'female', 1,         '123 Elm Street',       'medium',       '555-1234',       'single',     'Looking for companionship.'),
		('adopter',      'Bob',         'Johnson',     35, 'male',   2,         '456 Oak Avenue',       'high',         '555-5678',       'married',    'Loves animals.'),
		('rescuer',      'Catherine',   'Lee',         42, 'female', 3,         '789 Pine Road',        'low',          '555-9876',       'single',     'Rescuing stray animals.'),
		('adopter',      'Daniel',      'Brown',       30, 'male',   1,         '101 Maple Street',     'medium',       '555-4321',       'single',     'Wants to adopt a loyal pet.'),
		('adopter',      'Emily',       'Davis',       25, 'female', 2,         '202 Birch Lane',       'medium',       '555-6789',       'married',    'Looking for a family pet.');

INSERT INTO employee (first_name,          last_name,         sex,       age, employee_role,            years_of_experience, salary,      number_of_hours_worked, date_worked,    notes)
VALUES	('John',              'Doe',            'male',     35, 'Veterinarian',           10,                  75000.00,    160,                    '2024-11-15',  'Excellent at surgery.'),
		('Jane',              'Smith',          'female',   29, 'Animal Trainer',         5,                   45000.00,    150,                    '2024-11-14',  'Specializes in dog training.'),
		('Mike',              'Johnson',        'male',     40, 'Shelter Manager',        12,                  65000.00,    170,                    '2024-11-13',  'Oversees shelter operations.'),
		('Emily',             'Davis',          'female',   31, 'Veterinary Assistant',   6,                   40000.00,    155,                    '2024-11-12',  'Skilled at handling animals.'),
		('Chris',             'Brown',          'male',     27, 'Animal Caretaker',       3,                   30000.00,    140,                    '2024-11-11',  'Ensures proper feeding and cleaning.'),
		('Sarah',             'Wilson',         'female',   45, 'Behavior Specialist',    15,                  55000.00,    165,                    '2024-11-10',  'Focuses on animal behavioral issues.'),
		('David',             'Taylor',         'male',     33, 'Adoption Counselor',     7,                   42000.00,    160,                    '2024-11-09',  'Guides adopters through the process.'),
		('Olivia',            'Martinez',       'female',   26, 'Receptionist',           4,                   28000.00,    150,                    '2024-11-08',  'Handles appointments and calls.'),
		('James',             'Garcia',         'male',     38, 'Animal Transporter',     8,                   35000.00,    145,                    '2024-11-07',  'Transports animals between locations.'),
		('Sophia',            'Anderson',       'female',   30, 'Kennel Technician',      6,                   32000.00,    155,                    '2024-11-06',  'Maintains kennel cleanliness.');

INSERT INTO adoption (pet_id, adopter_id, employee_id, adoption_date, adoption_fee)
VALUES	(1,     1,          2,           '2024-11-16',  150.00),
		(2,     2,          3,           '2024-11-15',  200.00),
		(3,     3,          4,           '2024-11-14',  100.00),
		(4,     4,          1,           '2024-11-13',  180.00),
		(5,     5,          5,           '2024-11-12',  120.00);