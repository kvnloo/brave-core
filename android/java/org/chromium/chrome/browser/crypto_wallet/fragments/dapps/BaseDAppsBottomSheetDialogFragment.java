/* Copyright (c) 2022 The Brave Authors. All rights reserved.
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at https://mozilla.org/MPL/2.0/. */

package org.chromium.chrome.browser.crypto_wallet.fragments.dapps;

import org.chromium.brave_wallet.mojom.BraveWalletService;
import org.chromium.brave_wallet.mojom.JsonRpcService;
import org.chromium.brave_wallet.mojom.KeyringService;
import org.chromium.build.annotations.NullMarked;
import org.chromium.chrome.browser.app.domain.KeyringModel;
import org.chromium.chrome.browser.crypto_wallet.fragments.WalletBottomSheetDialogFragment;

@NullMarked
public class BaseDAppsBottomSheetDialogFragment extends WalletBottomSheetDialogFragment {

    private final BraveWalletService mBraveWalletService;
    private final KeyringService mKeyringService;
    private final JsonRpcService mJsonRpcService;

    public BaseDAppsBottomSheetDialogFragment(final KeyringModel keyringModel,
                                              final BraveWalletService braveWalletService,
                                              final KeyringService keyringService,
                                              final JsonRpcService jsonRpcService) {
        super(keyringModel);
        mBraveWalletService = braveWalletService;
        mKeyringService = keyringService;
        mJsonRpcService = jsonRpcService;
    }

    public BraveWalletService getBraveWalletService() {
        return mBraveWalletService;
    }

    public KeyringService getKeyringService() {
        return mKeyringService;
    }

    public JsonRpcService getJsonRpcService() {
        return mJsonRpcService;
    }
}
