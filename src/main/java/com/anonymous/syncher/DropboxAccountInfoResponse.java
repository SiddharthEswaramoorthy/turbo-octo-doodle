package com.anonymous.syncher;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.users.FullAccount;

public final class DropboxAccountInfoResponse {
    public FullAccount account;
    public DbxException exception;
    public boolean status;

    public DropboxAccountInfoResponse success(FullAccount account) {
        this.account = account;
        this.status = true;

        return this;
    }

    public DropboxAccountInfoResponse failure(DbxException exception) {
        this.exception = exception;
        this.status = false;

        return this;
    }
}
