package org.bitcoinj.params;

import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.core.Utils;
import org.bitcoinj.net.discovery.HttpDiscovery;
import org.bitcoinj.params.AbstractBitcoinNetParams;

import java.net.URI;


public class CcscoinRegTestParams extends AbstractBitcoinNetParams {
    public static final int MAINNET_MAJORITY_WINDOW = 1000;
    public static final int MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED = 950;
    public static final int MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE = 750;

    public CcscoinRegTestParams() {
        super();
        interval = INTERVAL;
        targetTimespan = TARGET_TIMESPAN;
        maxTarget = Utils.decodeCompactBits(0x1d00ffffL);
        dumpedPrivateKeyHeader = 239;
        addressHeader = 88;
        p2shHeader = 111;
        acceptableAddressCodes = new int[] { addressHeader, p2shHeader };
        port = 25888;
        packetMagic = 0xe2caffce;
        bip32HeaderPub = 0x043587CF; //The 4 byte header that serializes in base58 to "xpub".
        bip32HeaderPriv = 0x04358394; //The 4 byte header that serializes in base58 to "xprv"

        majorityEnforceBlockUpgrade = MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE;
        majorityRejectBlockOutdated = MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED;
        majorityWindow = MAINNET_MAJORITY_WINDOW;

        genesisBlock.setDifficultyTarget(0x207fffffL);
        genesisBlock.setTime(1615675571L);
        genesisBlock.setNonce(0);
        id = ID_CCSCOIN_REGTEST;
        subsidyDecreaseBlockCount = 985500;
        spendableCoinbaseDepth = 500;
        String genesisHash = genesisBlock.getHashAsString();
        checkState(genesisHash.equals("00009a0d65aff147f8af9ca00b768c2afbdfa275d0e041c7ee09d7466e7b38c2"), genesisHash);

        checkpoints.put(0, Sha256Hash.wrap("00009a0d65aff147f8af9ca00b768c2afbdfa275d0e041c7ee09d7466e7b38c2"));

        dnsSeeds = new String[] {
        };
        httpSeeds = new HttpDiscovery.Details[] {

        };

        addrSeeds = new int[] {};
    }

    private static CcscoinRegTestParams instance;
    public static synchronized CcscoinRegTestParams get() {
        if (instance == null) {
            instance = new CcscoinRegTestParams();
        }
        return instance;
    }

    @Override
    public String getPaymentProtocolId() {
        return PAYMENT_PROTOCOL_ID_MAINNET;
    }
}
