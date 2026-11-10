-- PROFILE

INSERT INTO profiles
(email, github, name, phone, summary, title)
VALUES
    (
        'inblagoev@gmail.com',
        'https://github.com/jabroris',
        'Ivaylo Blagoev',
        '+359 887 260 937',
        'Versatile and results-driven Software Engineer with over a decade of experience across fintech, environmental tech, automotive, and betting platforms. Proven expertise in building scalable backend systems using Java, Kotlin, Spring Boot, and Kafka. Adept at working in distributed teams, delivering secure and compliant solutions, and integrating with complex enterprise ecosystems. Passionate about clean architecture, continuous improvement, and solving real-world problems through code.',
        'Senior Software Engineer'
    );


-- SKILLS

INSERT INTO skills (category, level, name) VALUES ('Language', 5, 'Kotlin');
INSERT INTO skills (category, level, name) VALUES ('Language', 5, 'Java');
INSERT INTO skills (category, level, name) VALUES ('Language', 4, 'SQL');

INSERT INTO skills (category, level, name) VALUES ('Framework', 5, 'Spring Boot');
INSERT INTO skills (category, level, name) VALUES ('Framework', 4, 'Spring Security');
INSERT INTO skills (category, level, name) VALUES ('Framework', 5, 'Spring Data JPA');
INSERT INTO skills (category, level, name) VALUES ('Framework', 4, 'Spring Kafka');

INSERT INTO skills (category, level, name) VALUES ('Messaging', 4, 'Apache Kafka');
INSERT INTO skills (category, level, name) VALUES ('Messaging', 4, 'Event-Driven Architecture');

INSERT INTO skills (category, level, name) VALUES ('Architecture', 5, 'Microservices');
INSERT INTO skills (category, level, name) VALUES ('Architecture', 5, 'REST APIs');
INSERT INTO skills (category, level, name) VALUES ('Architecture', 4, 'Clean Architecture');

INSERT INTO skills (category, level, name) VALUES ('DevOps', 4, 'Docker');
INSERT INTO skills (category, level, name) VALUES ('DevOps', 5, 'Git');
INSERT INTO skills (category, level, name) VALUES ('DevOps', 4, 'Gradle / Maven');

INSERT INTO skills (category, level, name) VALUES ('Database', 4, 'PostgreSQL');
INSERT INTO skills (category, level, name) VALUES ('Database', 4, 'H2');

INSERT INTO skills (category, level, name) VALUES ('Blockchain', 3, 'Corda');
INSERT INTO skills (category, level, name) VALUES ('Blockchain', 3, 'Ethereum');


-- EXPERIENCE

INSERT INTO experience
(company, description, end_date, location, start_date, title)
VALUES
    (
        'CreateFuture',
        'Developed backend services for a high-scale betting platform. Architected and maintained microservices for the Orders Team. Ensured reliable event-driven communication and data consistency across distributed systems.',
        'Feb 2026',
        'Remote',
        'Jul 2025',
        'Java/Kotlin Developer'
    );

INSERT INTO experience
(company, description, end_date, location, start_date, title)
VALUES
    (
        'Paysafe (via Brainstars)',
        'Delivered full-stack development for Skrill''s KYC application. Built secure and scalable features using Java, Spring Boot, and modern frontend technologies. Collaborated with compliance and product teams to meet regulatory standards.',
        'Jun 2025',
        'Remote, Varna, Bulgaria',
        'Dec 2024',
        'Software Engineer (Contractor)'
    );

INSERT INTO experience
(company, description, end_date, location, start_date, title)
VALUES
    (
        'Lever X',
        'Designed and maintained enterprise-grade software solutions. Drove full SDLC from requirements analysis to deployment. Contributed to SAP-related projects.',
        'Aug 2024',
        'Remote, Sofia, Bulgaria',
        'Jan 2024',
        'Software Engineer'
    );

INSERT INTO experience
(company, description, end_date, location, start_date, title)
VALUES
    (
        'Industria Tech',
        'Developed internal and client-facing solutions. Integrated distributed ledger technologies including Corda and Ethereum.',
        'Dec 2023',
        'Remote, Sofia, Bulgaria',
        'Mar 2022',
        'Software Engineer'
    );

INSERT INTO experience
(company, description, end_date, location, start_date, title)
VALUES
    (
        'Catenate',
        'Engineered forecasting and ticketing software for BMW supplier networks. Enabled predictive analytics to identify production bottlenecks.',
        'Mar 2022',
        'Remote, Sofia, Bulgaria',
        'Aug 2021',
        'Java Engineer'
    );

INSERT INTO experience
(company, description, end_date, location, start_date, title)
VALUES
    (
        'Kipp & Zonen',
        'Built testing software for solar radiation sensors used in climate research. Coordinated product updates with R&D for seamless hardware-software integration.',
        'Mar 2020',
        'Delft, Netherlands',
        'Mar 2019',
        'Software Engineer'
    );

INSERT INTO experience
(company, description, end_date, location, start_date, title)
VALUES
    (
        'Sutron Corporation',
        'Developed and maintained environmental data acquisition systems (DAS, DCS Toolkit). Led development and deployment of hydrological platforms. Conducted international field deployments and client training.',
        'Feb 2019',
        'Sterling, VA, USA',
        'Dec 2011',
        'Software Engineer'
    );


-- EXPERIENCE TECHNOLOGIES

INSERT INTO experience_technologies VALUES (1, 'Kotlin');
INSERT INTO experience_technologies VALUES (1, 'Java');
INSERT INTO experience_technologies VALUES (1, 'Spring Boot');
INSERT INTO experience_technologies VALUES (1, 'Kafka');
INSERT INTO experience_technologies VALUES (1, 'Microservices');

INSERT INTO experience_technologies VALUES (2, 'Java');
INSERT INTO experience_technologies VALUES (2, 'Spring Boot');
INSERT INTO experience_technologies VALUES (2, 'Spring Security');
INSERT INTO experience_technologies VALUES (2, 'KYC');
INSERT INTO experience_technologies VALUES (2, 'Compliance');

INSERT INTO experience_technologies VALUES (3, 'Java');
INSERT INTO experience_technologies VALUES (3, 'Spring');
INSERT INTO experience_technologies VALUES (3, 'SAP CAP');
INSERT INTO experience_technologies VALUES (3, 'CDS');
INSERT INTO experience_technologies VALUES (3, 'Enterprise');

INSERT INTO experience_technologies VALUES (4, 'Java');
INSERT INTO experience_technologies VALUES (4, 'Kotlin');
INSERT INTO experience_technologies VALUES (4, 'Spring');
INSERT INTO experience_technologies VALUES (4, 'Corda');
INSERT INTO experience_technologies VALUES (4, 'Ethereum');
INSERT INTO experience_technologies VALUES (4, 'Blockchain');

INSERT INTO experience_technologies VALUES (5, 'Java');
INSERT INTO experience_technologies VALUES (5, 'Spring Boot');
INSERT INTO experience_technologies VALUES (5, 'Analytics');
INSERT INTO experience_technologies VALUES (5, 'Automotive');

INSERT INTO experience_technologies VALUES (6, 'Java');
INSERT INTO experience_technologies VALUES (6, 'Hardware Integration');
INSERT INTO experience_technologies VALUES (6, 'Climate Tech');
INSERT INTO experience_technologies VALUES (6, 'IoT');

INSERT INTO experience_technologies VALUES (7, 'Java');
INSERT INTO experience_technologies VALUES (7, 'Environmental Systems');
INSERT INTO experience_technologies VALUES (7, 'Data Acquisition');
INSERT INTO experience_technologies VALUES (7, 'Cloud');