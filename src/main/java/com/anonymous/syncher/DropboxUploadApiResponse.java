package com.anonymous.syncher;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.users.FullAccount;

public class DropboxUploadApiResponse {
    public FileMetadata account;
    public DbxException exception;
    public boolean status;

    public DropboxUploadApiResponse success(FileMetadata account) {
        this.account = account;
        this.status = true;

        return this;
    }

    public DropboxUploadApiResponse failure(DbxException exception) {
        this.exception = exception;
        this.status = false;

        return this;
    }
}
