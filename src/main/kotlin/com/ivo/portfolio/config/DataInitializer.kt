package com.ivo.portfolio.config

import com.ivo.portfolio.domain.Experience
import com.ivo.portfolio.domain.Profile
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.boot.CommandLineRunner
import com.ivo.portfolio.repository.SkillRepository
import com.ivo.portfolio.repository.ExperienceRepository
import com.ivo.portfolio.domain.Skill
import com.ivo.portfolio.dto.response.EducationDto
import com.ivo.portfolio.dto.response.LanguageDto
import com.ivo.portfolio.repository.ProfileRepository
import kotlin.String

@Configuration
class DataInitializer(
    private val skillRepository: SkillRepository,
    private val experienceRepository: ExperienceRepository,
    private val profileRepository: ProfileRepository
) {

    @Bean
    fun init() = CommandLineRunner {

        if (skillRepository.count() == 0L)
            seedSkills()

        if (experienceRepository.count() == 0L)
           seedExperiences()

        if (profileRepository.count() == 0L)
            seedProfile()
    }

    private fun seedProfile() {
        val profile = Profile(
            name = "Ivaylo Blagoev",
            title = "Senior Software Engineer",
            summary =
                """
                    Versatile and results-driven Software Engineer with over a decade of experience across fintech,
                    environmental tech, automotive, and betting platforms. Proven expertise in building scalable backend
                    systems using Java, Kotlin, Spring Boot, and Kafka. Adept at working in distributed teams, delivering
                    secure and compliant solutions, and integrating with complex enterprise ecosystems.
                    Passionate about clean architecture, continuous improvement, and solving real-world problems through code.
                """.trimIndent(),
            email = "inblagoev@gmail.com",
            phone = "+359 887 260 937",
            github = "www.github.com/jabroris",
        )
        profileRepository.save(profile)
    }

    private fun seedExperiences() {
        val experiences =
            listOf(
                Experience(
                    title = "Java/Kotlin Developer",
                    company = "CreateFuture",
                    location = "Remote",
                    startDate = "Jul 2025",
                    endDate = "Feb 2026",
                    description =
                        "Developed backend services for a high-scale betting platform. " +
                                "Architected and maintained microservices for the Orders Team. " +
                                "Ensured reliable event-driven communication and data consistency across distributed systems.",
                    technologies = mutableListOf("Kotlin", "Java", "Spring Boot", "Kafka", "Microservices"),
                ),
                Experience(
                    title = "Software Engineer (Contractor)",
                    company = "Paysafe (via Brainstars)",
                    location = "Remote, Varna, Bulgaria",
                    startDate = "Dec 2024",
                    endDate = "Jun 2025",
                    description =
                        "Delivered full-stack development for Skrill's KYC application. " +
                                "Built secure and scalable features using Java, Spring Boot, and modern frontend technologies. " +
                                "Collaborated with compliance and product teams to meet regulatory standards.",
                    technologies = mutableListOf("Java", "Spring Boot", "Spring Security", "KYC", "Compliance")
                ),
                Experience(
                    title = "Software Engineer",
                    company = "Lever X",
                    location = "Remote, Sofia, Bulgaria",
                    startDate = "Jan 2024",
                    endDate = "Aug 2024",
                    description =
                        "Designed and maintained enterprise-grade software solutions. " +
                                "Drove full SDLC from requirements analysis to deployment. " +
                                "Contributed to SAP-related projects.",
                    technologies = mutableListOf("Java", "Spring", "SAP CAP", "CDS", "Enterprise")
                ),
                Experience(
                    title = "Software Engineer",
                    company = "Industria Tech",
                    location = "Remote, Sofia, Bulgaria",
                    startDate = "Mar 2022",
                    endDate = "Dec 2023",
                    description =
                        "Developed internal and client-facing solutions. " +
                                "Integrated distributed ledger technologies including Corda and Ethereum.",
                    technologies = mutableListOf("Java", "Kotlin", "Spring", "Corda", "Ethereum", "Blockchain")
                ),
                Experience(
                    title = "Java Engineer",
                    company = "Catenate",
                    location = "Remote, Sofia, Bulgaria",
                    startDate = "Aug 2021",
                    endDate = "Mar 2022",
                    description =
                        "Engineered forecasting and ticketing software for BMW's supplier network. " +
                                "Enabled predictive analytics to identify production bottlenecks.",
                    technologies = mutableListOf("Java", "Spring Boot", "Analytics", "Automotive")
                ),
                Experience(
                    title = "Software Engineer",
                    company = "Kipp & Zonen",
                    location = "Delft, Netherlands",
                    startDate = "Mar 2019",
                    endDate = "Mar 2020",
                    description =
                        "Built testing software for solar radiation sensors used in climate research. " +
                                "Coordinated product updates with R&D for seamless hardware-software integration.",
                    technologies = mutableListOf("Java", "Hardware Integration", "Climate Tech", "IoT")
                ),
                Experience(
                    title = "Software Engineer",
                    company = "Sutron Corporation",
                    location = "Sterling, VA, USA",
                    startDate = "Dec 2011",
                    endDate = "Feb 2019",
                    description =
                        "Developed and maintained environmental data acquisition systems (DAS, DCS Toolkit). " +
                                "Led development and deployment of hydrological platforms (hydrometcloud.com, sutronwin.com). " +
                                "Conducted international field deployments and client training sessions.",
                    technologies = mutableListOf("Java", "Environmental Systems", "Data Acquisition", "Cloud")
                ),
            )
        experienceRepository.saveAll(experiences)
    }

    private fun seedSkills() {
        val skills =
            listOf(
                // Languages
                Skill(name = "Kotlin", category = "Language", level = 5),
                Skill(name = "Java", category = "Language", level = 5),
                Skill(name = "SQL", category = "Language", level = 4),
                // Frameworks
                Skill(name = "Spring Boot", category = "Framework", level = 5),
                Skill(name = "Spring Security", category = "Framework", level = 4),
                Skill(name = "Spring Data JPA", category = "Framework", level = 5),
                Skill(name = "Spring Kafka", category = "Framework", level = 4),
                // Messaging
                Skill(name = "Apache Kafka", category = "Messaging", level = 4),
                Skill(name = "Event-Driven Architecture", category = "Messaging", level = 4),
                // Architecture
                Skill(name = "Microservices", category = "Architecture", level = 5),
                Skill(name = "REST APIs", category = "Architecture", level = 5),
                Skill(name = "Clean Architecture", category = "Architecture", level = 4),
                // Tools
                Skill(name = "Docker", category = "DevOps", level = 4),
                Skill(name = "Git", category = "DevOps", level = 5),
                Skill(name = "Gradle / Maven", category = "DevOps", level = 4),
                // Databases
                Skill(name = "PostgreSQL", category = "Database", level = 4),
                Skill(name = "H2", category = "Database", level = 4),
                // Blockchain
                Skill(name = "Corda", category = "Blockchain", level = 3),
                Skill(name = "Ethereum", category = "Blockchain", level = 3),
            )
        skillRepository.saveAll(skills)
    }
}