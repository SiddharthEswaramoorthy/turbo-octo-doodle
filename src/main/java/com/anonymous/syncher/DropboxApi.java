package com.anonymous.syncher;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.WriteMode;
import com.dropbox.core.v2.users.FullAccount;

import java.io.IOException;
import java.io.InputStream;

public class DropboxApi {
    DbxClientV2 dropBoxClient;
    public DropboxApi(DbxClientV2 dropBoxClient) {
        this.dropBoxClient = dropBoxClient;
    }

    public DropboxAccountInfoResponse getAccountInfo(){
        try {
            FullAccount accountInfo = dropBoxClient.users().getCurrentAccount();
            return new DropboxAccountInfoResponse().success(accountInfo);
        } catch (DbxException exception) {
            return new DropboxAccountInfoResponse().failure(exception);
        }
    }

    public DropboxUploadApiResponse uploadFile(String fileName, InputStream inputStream) {
        try {
            FileMetadata fileMetaData = dropBoxClient.files()
                    .uploadBuilder("/" + fileName)
                    .withMode(WriteMode.OVERWRITE)
                    .uploadAndFinish(inputStream);
            return new DropboxUploadApiResponse().success(fileMetaData);
        } catch (DbxException exception) {
            return new DropboxUploadApiResponse().failure(exception);
        } catch (IOException e) {
            return null;
        }
    }

}
