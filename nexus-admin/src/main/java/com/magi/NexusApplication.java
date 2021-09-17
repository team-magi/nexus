package com.magi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * 启动程序
 *
 * @author nexus
 */
@Slf4j
@SpringBootApplication(scanBasePackages = {"com.magi"}, exclude = {DataSourceAutoConfiguration.class})
public class NexusApplication implements CommandLineRunner {
    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(NexusApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  Nexus启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n" +
                " |  _ _   \\      \\   \\   /  /    \n" +
                " | ( ' )  |       \\  _. /  '       \n" +
                " |(_ o _) /        _( )_ .'         \n" +
                " | (_,_).' __  ___(_ o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");
    }

    @Override
    public void run(String... strings) throws Exception {
        try {
            log.info("\n----------------------------------------------------------\n\t" +
                            "Application '{}' is running! Access URLs:\n\t" +
                            "Local: \t\thttp://127.0.0.1:{}\n\t" +
                            "External: \thttp://{}:{}{}/doc.html\n\t" +
                            "Profile(s): \t{}\n----------------------------------------------------------",
                    environment.getProperty("spring.application.name"),
                    environment.getProperty("server.port"),
                    InetAddress.getLocalHost().getHostAddress(),
                    environment.getProperty("server.port"),
                    environment.getProperty("server.servlet.context-path"),
                    Arrays.toString(environment.getActiveProfiles()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}