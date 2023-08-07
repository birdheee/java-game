package com.game;

import java.io.File;

public class RenameTest {
	
	public static void main(String[] args) {
		String rootPath = "C:\\william\\workspace\\html\\img";
		String targetPath = "C:\\william\\workspace\\html\\img\\cards\\";
		File rootFile = new File(rootPath);
		File[] dirs = rootFile.listFiles();
		int num = 0;
		for(File dir : dirs) {
			if(dir.isDirectory()) {
				File[] files = dir.listFiles();
				for(File file : files) {
					File targetFile = new File(targetPath + (num++) + ".png");
					file.renameTo(targetFile);
				}
			}
		}
	}
}
