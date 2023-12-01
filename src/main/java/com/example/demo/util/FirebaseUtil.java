package com.example.demo.util;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;

public class FirebaseUtil {
	public static String Upload(File file) throws IOException {
		String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/finalproject-73bd5.appspot.com/o/%s?alt=media";
		ClassPathResource serviceAccount = new ClassPathResource("firebase.json");
		BlobId blobId = BlobId.of("finalproject-73bd5.appspot.com", file.getName());
		BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
		Credentials credentials = GoogleCredentials.fromStream(serviceAccount.getInputStream());
		Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
		storage.create(blobInfo, Files.readAllBytes(file.toPath()));
		return String.format(DOWNLOAD_URL, URLEncoder.encode(file.getName(), StandardCharsets.UTF_8));
	}

	public static void Delete(String url) throws IOException {
		Pattern pattern = Pattern.compile(".*/(.*)\\?.*");
		Matcher matcher = pattern.matcher(url);
		if (matcher.matches()) {
			String fileName = matcher.group(1);
			ClassPathResource serviceAccount = new ClassPathResource("firebase.json");
			BlobId blobId = BlobId.of("finalproject-73bd5.appspot.com", fileName);
			Credentials credentials = GoogleCredentials.fromStream(serviceAccount.getInputStream());
			Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
			storage.delete(blobId);
		}
		else {
			throw new IOException("Input is invalid");
		}
	}
}
