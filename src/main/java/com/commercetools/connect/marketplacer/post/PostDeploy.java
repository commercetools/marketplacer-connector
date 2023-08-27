package com.commercetools.connect.marketplacer.post;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class PostDeploy {
    public static void main(String[] args) throws IOException {
        touch(System.getProperty("user.dir")+ "/POST_DEPLOY_SCRIPT");
    }

    private static void touch(String file) throws IOException {
        FileUtils.touch(new File(file));
    }
}
