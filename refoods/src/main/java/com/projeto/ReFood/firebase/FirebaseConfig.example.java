// package com.projeto.ReFood.firebase;

// import com.google.auth.oauth2.GoogleCredentials;
// import com.google.firebase.FirebaseApp;
// import com.google.firebase.FirebaseOptions;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import java.io.ByteArrayInputStream;
// import java.nio.charset.StandardCharsets;

// @Configuration
// public class FirebaseConfig {

//   @Value("${firebase.client.email}")
//   private String firebaseClientEmail;

//   @Value("${firebase.client.id}")
//   private String firebaseClientId;

//   @Value("${firebase.private.key.id}")
//   private String firebasePrivateKeyId;

//   // Partes da chave privada
//   @Value("${firebase.private.key.part1}")
//   private String privateKeyPart1;

//   @Value("${firebase.private.key.part2}")
//   private String privateKeyPart2;

//   @Value("${firebase.private.key.part3}")
//   private String privateKeyPart3;

//   @Value("${firebase.private.key.part4}")
//   private String privateKeyPart4;

//   @Value("${firebase.private.key.part5}")
//   private String privateKeyPart5;

//   @Value("${firebase.private.key.part6}")
//   private String privateKeyPart6;

//   // Chave privada completa
//   @Value("${firebase.private.key.complete}")
//   private String firebasePrivateKeyComplete;

//   private final String firebaseAuthProviderCertUrl = "https://www.googleapis.com/oauth2/v1/certs";
//   private final String firebaseAuthUri = "https://accounts.google.com/o/oauth2/auth";
//   private final String firebaseClientProviderCertUrl = "https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-onp2g%40refood-storage.iam.gserviceaccount.com";
//   private final String firebaseProjectId = "refood-storage";
//   private final String firebaseStorageBucket = "refood-storage.appspot.com";
//   private final String firebaseTokenUri = "https://oauth2.googleapis.com/token";
//   private final String firebaseUniverseDomain = "googleapis.com";

//   @Bean
//   public FirebaseApp initializeFirebase() throws Exception {
//     // Concatenar as partes da chave privada
//     String privateKey = privateKeyPart1 + privateKeyPart2 + privateKeyPart3 +
//         privateKeyPart4 + privateKeyPart5 + privateKeyPart6;

//     privateKey = privateKey.replace("\\n", "\n");

//     // Criar a string JSON de credenciais
//     String credentialsJson = String.format(
//         "{ \"type\": \"service_account\", \"project_id\": \"%s\", \"private_key_id\": \"%s\", \"private_key\": \"%s\", \"client_email\": \"%s\", \"client_id\": \"%s\", \"auth_uri\": \"%s\", \"token_uri\": \"%s\", \"auth_provider_x509_cert_url\": \"%s\", \"client_x509_cert_url\": \"%s\", \"universe_domain\": \"%s\" }",
//         firebaseProjectId,
//         firebasePrivateKeyId,
//         privateKey,
//         firebaseClientEmail,
//         firebaseClientId,
//         firebaseAuthUri,
//         firebaseTokenUri,
//         firebaseAuthProviderCertUrl,
//         firebaseClientProviderCertUrl,
//         firebaseUniverseDomain); // clientCertUrl

//     // Converter a string JSON para um InputStream
//     ByteArrayInputStream credentialsStream = new ByteArrayInputStream(credentialsJson.getBytes(StandardCharsets.UTF_8));

//     GoogleCredentials credentials = GoogleCredentials.fromStream(credentialsStream);

//     FirebaseOptions options = FirebaseOptions.builder()
//         .setCredentials(credentials)
//         .setStorageBucket(firebaseStorageBucket)
//         .build();

//     return FirebaseApp.initializeApp(options);
//   }
// }
