/* Copyright (c) 2023 The Brave Authors. All rights reserved.
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/. */

package org.chromium.chrome.browser.crypto_wallet.fragments;

import android.content.DialogInterface;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.chromium.build.annotations.NullMarked;
import org.chromium.chrome.browser.app.domain.KeyringModel;
import org.chromium.chrome.browser.crypto_wallet.observers.KeyringServiceObserverImpl;

/**
 * Base class for {@code BottomSheetDialogFragment} with wallet specific implementation
 * (auto-dismiss when locked, clean up etc).
 */
@NullMarked
public class WalletBottomSheetDialogFragment extends BottomSheetDialogFragment
        implements KeyringServiceObserverImpl.KeyringServiceObserverImplDelegate {
    private final KeyringServiceObserverImpl mKeyringObserver;
    private final KeyringModel mKeyringModel;

    public WalletBottomSheetDialogFragment(final KeyringModel keyringModel) {
        mKeyringObserver = new KeyringServiceObserverImpl(this);
        mKeyringModel = keyringModel;
        mKeyringModel.registerKeyringObserver(mKeyringObserver);
    }

    protected KeyringModel getKeyringModel() {
        return mKeyringModel;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        mKeyringObserver.close();
        super.onDismiss(dialog);
    }

    @Override
    public void locked() {
        dismiss();
    }
}
