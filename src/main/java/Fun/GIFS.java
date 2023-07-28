package Fun;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

import java.awt.*;
import java.util.Locale;
import java.util.Random;

public class GIFS extends ListenerAdapter {

    Random rand = new Random();
    Color color = new Color(98, 78, 237);
    int r, rList;

    String[] nomAction = {"eats", "consumes", "noms", "bites"};
    String[] nomList = {"https://cdn.weeb.sh/images/rJAlbgXsb.gif", "https://cdn.weeb.sh/images/rJjd1nDLz.gif", "https://cdn.weeb.sh/images/Sys3xg7jW.gif", "https://cdn.weeb.sh/images/Hk1sxlQjZ.gif", "https://cdn.weeb.sh/images/BJXRmfr6-.gif", "https://cdn.weeb.sh/images/ry00lxmob.gif", "https://cdn.weeb.sh/images/r1Vk-x7sZ.gif", "https://cdn.weeb.sh/images/rk8illmiW.gif", "https://cdn.weeb.sh/images/rkNgZlXi-.gif", "https://cdn.weeb.sh/images/S1FOllQj-.gif", "https://cdn.weeb.sh/images/H1gYelQjZ.gif", "https://i.pinimg.com/originals/21/3c/5a/213c5a93142eb37cd2a986b7d4cb123a.gif"};

    String[] patAction = {"pets", "pats"};
    String[] patList= {"https://cdn.weeb.sh/images/B1D9J1tvZ.gif", "https://cdn.weeb.sh/images/SJva1kFv-.gif", "https://cdn.weeb.sh/images/HJGQlJYwb.gif", "https://cdn.weeb.sh/images/SJS1lyYwW.gif", "https://cdn.weeb.sh/images/r1Y5L6NCZ.gif", "https://cdn.weeb.sh/images/ryh6x04Rb.gif", "https://cdn.weeb.sh/images/SktIxo20b.gif", "https://cdn.weeb.sh/images/BJp1lyYD-.gif", "https://cdn.weeb.sh/images/Sk2FyQHpZ.gif", "https://cdn.weeb.sh/images/rytzGAE0W.gif", "https://cdn.weeb.sh/images/Sy6Gektw-.gif", "https://cdn.weeb.sh/images/BkaRWA4CZ.gif", "https://cdn.weeb.sh/images/HJRIlihCZ.gif", "https://cdn.weeb.sh/images/ByOc1ktv-.gif", "https://cdn.weeb.sh/images/S1ja11KD-.gif", "https://cdn.weeb.sh/images/rJ4E1ep7f.gif", "https://cdn.weeb.sh/images/HkZqkyFvZ.gif", "https://cdn.weeb.sh/images/rktgg1Yv-.gif", "https://cdn.weeb.sh/images/SyFmqkFwW.gif", "https://cdn.weeb.sh/images/SJLaWWRSG.gif", "https://cdn.weeb.sh/images/HyxG31ktDb.gif", "https://cdn.weeb.sh/images/r1lVQgcyG.gif", "https://cdn.weeb.sh/images/H1MIei2AZ.gif", "https://cdn.weeb.sh/images/rkZbJAYKW.gif", "https://cdn.weeb.sh/images/ryV2k1tP-.gif", "https://cdn.weeb.sh/images/SJmW1RKtb.gif", "https://cdn.weeb.sh/images/H1XkAyYNM.gif", "https://cdn.weeb.sh/images/Sk2f7J39G.gif", "https://cdn.weeb.sh/images/B1PnJJYP-.gif", "https://cdn.weeb.sh/images/rJWRykFvZ.gif", "https://cdn.weeb.sh/images/rkl1xJYDZ.gif", "https://cdn.weeb.sh/images/H1s5hx0Bf.gif", "https://cdn.weeb.sh/images/r1goyytPZ.gif", "https://cdn.weeb.sh/images/Bk4Ry1KD-.gif", "https://cdn.weeb.sh/images/rJ1WlyKPZ.gif", "https://cdn.weeb.sh/images/rkTC896_f.gif", "https://cdn.weeb.sh/images/SyFkekYwW.gif", "https://cdn.weeb.sh/images/SJudB96_f.gif", "https://cdn.weeb.sh/images/rybs1yFDb.gif", "https://cdn.weeb.sh/images/B1TQcTNCZ.gif", "https://cdn.weeb.sh/images/HyWlxJFvb.gif", "https://cdn.weeb.sh/images/rkBZkRttW.gif", "https://cdn.weeb.sh/images/HyqTkyFvb.gif", "https://cdn.weeb.sh/images/B1FqkJKPW.gif", "https://cdn.weeb.sh/images/Hkccqp4A-.gif", "https://cdn.weeb.sh/images/rJMskkFvb.gif", "https://cdn.weeb.sh/images/H1Vc1yYwW.gif", "https://media.tenor.com/images/dbdb944f852228eaa8b45bfb9dadeb32/tenor.gif"};

    String[] stareAction = {"stares at"};
    String[] stareList = {"http://pa1.narvii.com/7131/7779ad7738a4cf74c457a3a762533312bd34e7der1-245-160_00.gif", "https://cdn.weeb.sh/images/SygCDUkYPb.gif", "http://68.media.tumblr.com/aa0d6fb7aa8e8c76c26931551ff8027d/tumblr_ol0aibEmI71v06cowo1_500.gif", "https://i.kym-cdn.com/photos/images/original/000/515/580/56a.gif", "https://c.tenor.com/DYLZTJLYyukAAAAM/himouto-umaruchan-eating.gif", "https://media0.giphy.com/media/6IkjQmpaRwIabJ2G3C/200.gif?cid=ecf05e47fp8vta9cmlm9grrvxje0f7zxrf2364p7n77a3uc3&rid=200.gif", "https://cdn.discordapp.com/attachments/793141509800460318/841528814696923176/92D5D5FA-928A-484C-B188-9C965C72AA76.gif"};

    String[] punchAction = {"punches", "knocks out"};
    String[] punchList = {"https://thumbs.gfycat.com/AmusingPinkCapeghostfrog-size_restricted.gif", "https://thumbs.gfycat.com/AmusingPinkCapeghostfrog-size_restricted.gif", "https://media.tenor.com/images/b96f63d9382fe52cfe43feac4a8a40d6/tenor.gif","https://pa1.narvii.com/5678/b3bd738b12075bbd475a791f8963d9f336388b36_hq.gif", "https://i.kym-cdn.com/photos/images/original/000/989/495/3b8.gif", "https://i.pinimg.com/originals/1f/19/77/1f1977a079a3876924587b67c9822034.gif", "https://3.bp.blogspot.com/-f2C5CBKw05A/W95nlOPZ4HI/AAAAAAABXVo/eU16NRt_qQIh64c3AvSScDYuRL2H6lAegCKgBGAs/s1600/Omake%2BGif%2BAnime%2B-%2BFairy%2BTail%2BFinal%2BSeason%2B-%2BEpisode%2B282%2B-%2BLucy%2BPunch.gif", "https://i.pinimg.com/originals/83/36/06/833606f00f69e3a96c78b64f16e22837.gif", "https://static.wikia.nocookie.net/jujutsu-kaisen/images/e/eb/Yuji_kills_Eso_%28Anime%29.gif"};

    String[] bonkAction = {"bonks"};
    String[] bonkList = {"https://media.tenor.com/images/47698b115e4185036e95111f81baab45/tenor.gif", "https://media1.tenor.com/images/0074644822b79ad12743b8a3371a8478/tenor.gif?itemid=15999942", "https://i.pinimg.com/originals/99/ea/48/99ea48ec7a3d63e77186302e8d85426e.gif", "https://i.pinimg.com/originals/64/c8/97/64c8972b9f422740a425628cfc1c2423.gif", "https://imgur.com/0IxjsfM.gif", "https://media.tenor.com/images/47698b115e4185036e95111f81baab45/tenor.gif", "https://gifimage.net/wp-content/uploads/2017/10/nozoki-ana-gif-1.gif"};

    String[] runAction = {"runs from"};
    String[] runList = {"https://i.pinimg.com/originals/21/3c/5a/213c5a93142eb37cd2a986b7d4cb123a.gif", "https://imgur.com/LAzrCjl.gif", "https://i.kym-cdn.com/photos/images/original/001/551/110/769.gif", "https://i.kym-cdn.com/photos/images/newsfeed/001/081/817/909.gif", "https://i.kym-cdn.com/photos/images/newsfeed/001/261/339/d17.gif", "https://pa1.narvii.com/5887/0bfb2b2224d514d913c71677e584c9afab9fe4fa_hq.gif"};

    String[] killAction = {"kills", "destroys", "unexists"};
    String[] killList = {"http://anigifs.files.wordpress.com/2011/05/nchij_e16_p3.gif", "https://i.pinimg.com/originals/4a/31/89/4a318955616b07d9f93e279945c1ffe4.gif", "https://i.gifer.com/P4H8.gif", "https://31.media.tumblr.com/tumblr_m9x22476F71rn53vuo1_500.gif", "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/84808694-a644-4ebb-a091-ef422987693c/d72u6us-9e4a20c1-07b5-47ff-8dab-f0a81d310feb.gif?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzg0ODA4Njk0LWE2NDQtNGViYi1hMDkxLWVmNDIyOTg3NjkzY1wvZDcydTZ1cy05ZTRhMjBjMS0wN2I1LTQ3ZmYtOGRhYi1mMGE4MWQzMTBmZWIuZ2lmIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.SNpopmo_xF5U_-wXNhhzMJn2ZZm6kCc4H_znIIeMu14", "https://pa1.narvii.com/5820/cdea42b0deeaf161f8e17183e29de3bd96f38066_hq.gif", "https://i.pinimg.com/originals/b4/fa/cf/b4facf8545a82dccc9ef33ddf31fcb95.gif", "https://imgur.com/TnUJu9C.gif.gif", "https://pa1.narvii.com/6519/b2d70fd4b2bcedeeb69e3841529c37b0f74b4991_hq.gif", "https://i.pinimg.com/originals/22/a7/3f/22a73f904eb57a3e5d5745bc0d7423a2.gif", "https://4.bp.blogspot.com/-L6x3_i8hdx8/XH3KAG0Vt9I/AAAAAAABdpk/ezoJUpdnokosAUdOEg7YgpVr50SttOQpQCKgBGAs/s1600/Omake%2BGif%2BAnime%2B-%2BMob%2BPsycho%2B100%2BS2%2B-%2BEpisode%2B9%2B-%2BMob%2BPunches.gif", "https://66.media.tumblr.com/ff8f504231242364f0bb657165e1be3b/tumblr_pmik5fFw9K1se015qo1_540.gif", "https://i.imgur.com/IxS05dk.gif", "https://animesher.com/orig/0/67/678/6780/animesher.com_no-nichijou-danshi-koukousei-678039.gif", "https://media.tenor.com/images/01371dbaf3bb93a5beb0a8f64d9217b2/tenor.gif", "https://cdn.discordapp.com/attachments/793141509800460318/841528800647053322/491BD7D2-4B9D-4BA9-92BC-EA095B336511.gif"};

    String[] glareAction = {"glares at"};
    String[] glareList = {"https://data.whicdn.com/images/197125909/original.gif", "https://imgur.com/C3tli.gif", "https://i.gifer.com/8dQm.gif", "https://i.pinimg.com/originals/b8/46/86/b84686fe410bd4eed33be27a0718251d.gif", "https://media.tenor.com/images/fcba8c08acd4d5dd15f182baa9471b6f/tenor.gif", "https://pa1.narvii.com/5931/d0d18f58483d30b33457316b67a86e6629e454e3_hq.gif", "https://thumbs.gfycat.com/FlakyHappygoluckyCrab-max-1mb.gif", "https://64.media.tumblr.com/f58d2de9c2e8d59ed7f52108e1f58b4d/tumblr_inline_nj3goqTT251qc8ajp.gif", "https://i.gifer.com/A904.gif"};

    String[] mockAction = {"laughs at", "mocks", "threatens"};
    String[] mockList = {"https://i.pinimg.com/originals/b3/a5/61/b3a561c7be04c01acaeddedf16240c98.gif","https://media.tenor.com/images/5cdc0629518a366272ec84f55f904d04/tenor.gif", "https://imgur.com/qFmCGDU.gif", "https://media.tenor.com/images/906115320e11930844e733280f5e600f/tenor.gif", "https://i.gifer.com/EciR.gif", "https://media.tenor.com/images/4416ac9ffc5961ab30d7fec52c881e96/tenor.gif", "https://i.gifer.com/ByO1.gif", "https://i.redd.it/3jmzv3a18ak11.gif", "https://thumbs.gfycat.com/DescriptiveSmartKitty-max-1mb.gif", "https://1.bp.blogspot.com/-D6a7ySLggAk/W0Q-wVJM2gI/AAAAAAABPl8/W_Y4Xjr6G2UTO66HqY4ymoF4eTIIqH2TACKgBGAs/s1600/Omake%2BGif%2BAnime%2B-%2BAsobi%2BAsobase%2B-%2BEpisode%2B1%2B-%2BOlivia%2BSuper%2BSmug.gif", "https://i.kym-cdn.com/photos/images/original/000/788/971/454.gif", "https://i.pinimg.com/originals/3d/30/7e/3d307ec0e73bb68003bd32100aa72298.gif", "https://cdn.discordapp.com/attachments/793141509800460318/841528814379073546/00B98CF4-B5E9-43A5-B4B3-1F795700B8FE.gif"};

    String[] hugAction = {"hugs", "huggles"};
    String[] hugList = {"https://pa1.narvii.com/6472/3632e18c275a6996aa641bd219320b988c787e48_hq.gif", "https://media.giphy.com/media/VGACXbkf0AeGs/giphy.gif", "https://pa1.narvii.com/5579/655d65d49a2981f2fcfc6d94a397db884c703779_hq.gif", "https://pa1.narvii.com/5824/bb28c25271dc929983d3ba161fbc37571a023f1a_hq.gif", "https://i.pinimg.com/originals/0c/bc/37/0cbc377124f2f91d76277160b5803372.gif", "https://i.pinimg.com/originals/0b/7e/e5/0b7ee568f43a440e8bca7f96188fb432.gif", "https://i.pinimg.com/originals/85/dc/ef/85dcef131af84b515106955e142df54e.gif", "https://i.kym-cdn.com/photos/images/original/000/935/627/3a5.gif", "https://1.bp.blogspot.com/-86yVsCoo8Lg/YG74owL3TRI/AAAAAAAAD_g/bzEb8XecokcC7jyolOFu6w44nhklUSCwQCLcBGAsYHQ/w380/anime%2Bhug%2Bgif1.gif", "https://i.pinimg.com/originals/24/7f/5c/247f5c648343ff5beb421eb463eaff04.gif", "https://pa1.narvii.com/6196/728792595f45b1fb03bb31b18b684aac89cc40a8_hq.gif", "https://media.tenor.com/images/78df201d73bd49dc80648f0bf2e4df04/tenor.gif"};

    String[] boopAction = {"boops"};
    String[] boopList = {"https://cdn.weeb.sh/images/SyJzRTKFW.gif", "https://i.pinimg.com/originals/b4/95/fb/b495fb19f4b9a1b04f48297b676c497b.gif", "https://media.tenor.com/images/2ff785b647ef22f7110b3b2599e4c847/tenor.gif", "https://imgur.com/787H2cR.gif", "https://cdn.weeb.sh/images/HkxwlkKPb.gif", "https://cdn.weeb.sh/images/SyQzRaFFb.gif", "https://cdn.weeb.sh/images/BkcSekKwb.gif", "https://cdn.weeb.sh/images/rktSlkKvb.gif", "https://cdn.weeb.sh/images/rkaUe1YPb.gif", "https://cdn.weeb.sh/images/HkjjLb0rM.gif"};

    String[] waveAction = {"waves at"};
    String[] waveList = {"https://i.pinimg.com/originals/05/6c/58/056c584d9335fcabf080ca43e583e3c4.gif", "https://media3.giphy.com/media/3oz8xTAJIQD6JWfTUc/giphy.gif", "https://imgur.com/CK3cqde.gif", "https://imgur.com/u2Z87a4.gif", "https://media.tenor.com/images/33ee3367675a99d39888a7ad273e0291/tenor.gif", "https://pa1.narvii.com/7313/68e5969b157afc37d08daa0ce0b38d87db392916r1-480-268_hq.gif", "https://aws1.discourse-cdn.com/wanikanicommunity/original/4X/b/d/8/bd8a72cf36b65e9531511adaa45de575808e2586.gif", "https://media.tenor.com/images/4b9b18c7aae49b108354a22a0cb615fc/tenor.gif", "https://media.tenor.com/images/454cae3260426b7357adee5ed07c7aee/tenor.gif", "https://media.tenor.com/images/5167f63c4c01e29abb68832927f8a067/tenor.gif", "https://imgur.com/TMaBtNt.gif", "https://media.tenor.com/images/7a406ffe8f3e32f53386057948d84b7a/tenor.gif", "https://media.tenor.com/images/8d1df7d9334186c5336650d83a7aa1cd/tenor.gif"};



    String[] sadAction = {"is sad"};
    String[] sadList = {"https://64.media.tumblr.com/2f64d496cd0e00874eac18fcf384dd24/tumblr_nt612bRLFD1tp4szso9_400.gif", "https://i.kym-cdn.com/photos/images/original/000/516/083/160.gif", "https://thumbs.gfycat.com/BasicNiceBedlingtonterrier-size_restricted.gif", "http://31.media.tumblr.com/2de7f8f716aca65a62e0bd9812173c03/tumblr_n6knpxaH3I1qd16pfo3_500.gif", "https://media3.giphy.com/media/cjOqRWZXyspLq/giphy.gif", "https://c.tenor.com/mN_l80FzR70AAAAM/umaru-san-cry.gif", "https://c.tenor.com/yTEHRx1ofG4AAAAM/umaru-chan-tears.gif", "https://i2.wp.com/media1.giphy.com/media/enp5EEnd1wlLq/giphy.gif", "http://pa1.narvii.com/5692/f52c487404e6dd9043a2a559db75bcd3571dd89b_00.gif", "https://i.pinimg.com/originals/23/68/65/236865317ffe75038ed8b739d5bb0cea.gif", "http://33.media.tumblr.com/e8ab776c233f2e595216de7a7b6b96ea/tumblr_ndwvljJ4YU1s20ivko1_500.gif", "https://cdn.discordapp.com/attachments/793141509800460318/841528778857512980/5E75B626-E5DF-4D0C-A5BD-BE0B630D680D.gif"};

    String[] blushAction = {"blushes"};
    String[] blushList = {"https://thumbs.gfycat.com/CoordinatedVainGermanwirehairedpointer-size_restricted.gif", "https://i.kym-cdn.com/photos/images/original/001/251/527/e65.gif", "https://64.media.tumblr.com/07510ec004083e5e31c2a3431a54792e/tumblr_inline_ptlg96NNBr1vlymoj_500.gif"};

    String[] confusedAction = {"is confused"};
    String[] confusedList = {"https://media3.giphy.com/media/2WawMIQgUbJK/giphy.gif", "http://31.media.tumblr.com/8bb49843089eede2b30491ede14ec39f/tumblr_n01xrwJgNS1s8sotmo1_500.gif", "https://33.media.tumblr.com/dbf17dabed222b1718cb9497c7008564/tumblr_noattyqTNU1u21ng6o1_500.gif", "https://i.kym-cdn.com/photos/images/original/000/891/538/474.gif", "https://i.pinimg.com/originals/43/05/ae/4305ae710645bbf610fac0bf730e6f29.gif", "https://media.tenor.com/images/0a91a0fc132b5d3658e426cd8ffbf4b6/tenor.gif", "https://c.tenor.com/0QfccTPyq0EAAAAM/kei-tsukishima.gif", "https://c.tenor.com/szlmaldvCC8AAAAM/haikyuu-anime.gif"};

    String[] nicoAction = {"nico nico nii"};
    String[] nicoList = {"https://media.tenor.com/images/f781e12ff4b4e4316607406f1fb72c86/tenor.gif"};

    String[] sleepAction = {"sleeps", "naps", "passes out from exhaustion", "goodnights"};
    String[] sleepList = {"https://animesher.com/orig/0/84/846/8461/animesher.com_nichijou-gif-hakase-846144.gif", "https://japanpowered.com/media/images/sleeping-hunter-hunter.gif", "https://i.pinimg.com/originals/e7/d8/20/e7d820df79f40685c63b549009b96c71.gif", "https://i.kym-cdn.com/photos/images/original/001/372/573/651.gif", "https://i.pinimg.com/originals/df/1d/8b/df1d8b3bec2f022d177edfcf9994d54e.gif", "https://imgur.com/e5VyGdA.gif"};

    String[] angyAction = {"angy"};
    String[] angyList = {"http://mrwgifs.com/wp-content/uploads/2013/04/Crying-And-Throwing-a-Fit-MRW-Gif-On-Nichijou.gif", "https://c.tenor.com/oR2zWEYO8mcAAAAM/himouto-umaru.gif", "https://thumbs.gfycat.com/HollowBadHeifer-size_restricted.gif", "https://images.gr-assets.com/hostedimages/1380419224ra/830899.gif", "https://i.pinimg.com/originals/ac/ca/82/acca82e2dad14fb7c21d278edd6aba48.gif"};

    String[] smileAction = {"smiles"};
    String[] smileList = {"https://i.pinimg.com/originals/99/32/6b/99326b6d94347d965920aad57a963fec.gif", "https://thumbs.gfycat.com/SlightLargeCondor-size_restricted.gif", "https://i.pinimg.com/originals/81/55/94/815594c7464a9e895d875cb52a667351.gif", "https://imgur.com/EdkQSt0.gif", "https://thumbs.gfycat.com/UnrealisticFeistyFirecrest-size_restricted.gif", "https://i.pinimg.com/originals/4e/05/3e/4e053e3abc8d589d1e6e0506332b0203.gif", "https://i.imgur.com/xUsF7yB.gif", "https://cdn.discordapp.com/attachments/793141509800460318/841528799140118528/C9535D1A-5677-43FB-BBF5-7987AB2D9D9E.gif", "https://data.whicdn.com/images/287980729/original.gif", "https://i.pinimg.com/originals/d7/8e/62/d78e6235400b15af652ce3006b033d48.gif", "https://c.tenor.com/HF5xnX-okgIAAAAM/anime-manga.gif"};

    String[] smirkAction = {"smirks"};
    String[] smirkList = {"https://media1.tenor.com/images/96ec47dcb94abeb01fe46d61ff7a6cb6/tenor.gif", "https://cdn140.picsart.com/311443567233201.gif?to=min&r=640", "https://i.kym-cdn.com/photos/images/newsfeed/000/621/670/b10.gif", "https://i.pinimg.com/originals/c1/6a/f6/c16af64a87da25066ac792d0478a345b.gif", "https://imgur.com/9btCVKL.gif", "https://i.kym-cdn.com/photos/images/newsfeed/000/927/064/776.gif", "https://i.kym-cdn.com/photos/images/newsfeed/000/927/202/531.gif", "https://pa1.narvii.com/6938/3b0778a09e7455350bab043ff6251aa44d0531d7r1-500-280_hq.gif", "https://media2.giphy.com/media/hs10thTymzgO2QqcTG/giphy.gif"};

    String[] winkAction = {"winks"};
    String[] winkList = {"https://c.tenor.com/OnT-5xHIYAwAAAAM/umaru-himouto.gif", "https://i.gifer.com/5Jfb.gif"};

    String[] shockAction = {"is shocked"};
    String[] shockList = {"http://68.media.tumblr.com/814245345bfb3e5791ce0bb289232563/tumblr_onu8fo7giu1u9msabo1_540.gif", "https://media1.giphy.com/media/aqECqHcw5CqB2/giphy.gif", "https://media.tenor.com/images/de45735412aa9b4e3421380134f9c61e/tenor.gif","https://i.kym-cdn.com/photos/images/newsfeed/000/543/398/2f3.gif", "https://30.media.tumblr.com/tumblr_lxlnqb0qEs1r9ru7qo2_500.gif"};

    String[] laughAction = {"laughs"};
    String[] laughList = {"https://i.pinimg.com/originals/1a/5d/b2/1a5db29d36c61235835c108ff09d4cf8.gif", "https://giffiles.alphacoders.com/114/114851.gif", "https://i.pinimg.com/originals/fa/8b/3a/fa8b3a4afc5239f77267f2082afccb8b.gif"};

    String[] disgustAction = {"is disgusted"};
    String[] disgustList = {"https://i.pinimg.com/originals/36/2a/ea/362aeaaa96fdc2a4d481b5509ed5c6d3.gif"};

    String[] poutAction = {"pouts"};
    String[] poutList = {"https://i.pinimg.com/originals/bd/3d/96/bd3d966ca08c6d46b9ace03185b64d6d.gif"};

    String[] braindeadAction = {"is braindead", "dies inside"};
    String[] braindeadList = {"https://media.tenor.com/images/31c5a212899c9d633f575bacf738dc15/tenor.gif", "https://aws1.discourse-cdn.com/eveonline/original/3X/5/b/5bb0372b1839d39e13331287e9a445c4fccdd8d3.gif", "https://ci.memecdn.com/10042933.gif", "https://i.pinimg.com/originals/79/1b/2e/791b2e9a7040c6930a4ab71baa7296db.gif", "https://pa1.narvii.com/6537/cc71c64e950f6ac1d9201ffaa462148c28a8ea2c_hq.gif", "https://pa1.narvii.com/5930/3f5fa896c15fd2a52b80a5a225391be002250e6b_hq.gif", "http://images6.fanpop.com/image/photos/43000000/Kuroko-use-Head-Smash-random-43067767-300-250.gif", "https://i.pinimg.com/originals/39/83/4c/39834cd4202dd228012ff74fbf789477.gif"};

    String[] decomposeAction = {"is decomposing", "withers away"};
    String[] decomposeList = {"https://media3.giphy.com/media/iQ23jO6ItXO12/giphy.gif", "https://c.tenor.com/y0dPmn6pPF8AAAAC/crying-dying.gif"};




    public void onSlashCommandInteraction(SlashCommandInteraction e){
        EmbedBuilder builder = new EmbedBuilder();
        builder.setColor(color);

//        if(e.getName().equals("generate")){
//            builder.setImage("https://cdn.discordapp.com/attachments/793141509800460318/841528799140118528/C9535D1A-5677-43FB-BBF5-7987AB2D9D9E.gif");
//            e.getChannel().sendMessage(builder.build()).queue();
//        }

        if(e.getName().toLowerCase().startsWith("gif_pat")){
            createAction(e, patAction, patList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_nom")){
            createAction(e, nomAction, nomList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_stare")){
            createAction(e, stareAction, stareList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_punch")){
            createAction(e, punchAction, punchList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_bonk")){
            createAction(e, bonkAction, bonkList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_run")){
            createAction(e, runAction, runList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_kill")){
            createAction(e, killAction, killList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_glare")){
            createAction(e, glareAction, glareList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_mock")) {
            createAction(e, mockAction, mockList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_hug")) {
            createAction(e, hugAction, hugList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_boop")) {
            createAction(e, boopAction, boopList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_wave")) {
            createAction(e, waveAction, waveList, builder);
        }

        if(e.getName().toLowerCase().startsWith("gif_sad")){
            createEmotion(e, sadAction, sadList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_blush")) {
            createEmotion(e, blushAction, blushList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_confused")) {
            createEmotion(e, confusedAction, confusedList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_nico")) {
            createEmotion(e, nicoAction, nicoList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_sleep")) {
            createEmotion(e, sleepAction, sleepList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_angy")) {
            createEmotion(e, angyAction, angyList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_smile")){
            createEmotion(e, smileAction, smileList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_smirk")) {
            createEmotion(e, smirkAction, smirkList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_winks")) {
            createEmotion(e, winkAction, winkList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_shock")) {
            createEmotion(e, shockAction, shockList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_laugh")) {
            createEmotion(e, laughAction, laughList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_disgust")) {
            createEmotion(e, disgustAction, disgustList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_pout")) {
            createEmotion(e, poutAction, poutList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_braindead")) {
            createEmotion(e, braindeadAction, braindeadList, builder);
        } else if(e.getName().toLowerCase().startsWith("gif_decompose")) {
            createEmotion(e, decomposeAction, decomposeList, builder);
        }

    }

    public void createAction(SlashCommandInteraction e, String[] xAction, String[] xList, EmbedBuilder builder){
        r = rand.nextInt(xAction.length); rList = rand.nextInt(xList.length);
        OptionMapping opt = e.getOption("name");
        User mentionedUser = opt.getMentions().getUsers().get(0);
//        String actionName = e.getName().substring(4, e.getName().indexOf(" ", 4));

        try{
            String actionName = e.getName().substring(4);
            if(e.getName().length() > (4 + actionName.length())){
//            e.getChannel().sendMessage("length " + mentionedUser.getAsMention().length()).queue();
                builder.setFooter(mentionedUser.getName() + " is being " + actionName);
            }
        } catch (StringIndexOutOfBoundsException ignored){ }
//
//        if(e.getName().length() > (4 + xAction[r].length())){
//            String message = e.getName().substring(4 + xAction[r].length() + 1 + mentionedUser.getAsMention().length());
//            builder.setFooter(message);
//        }
        builder.setImage(xList[rList]);
        builder.setAuthor(e.getUser().getName() + " " + xAction[r], null, e.getUser().getAvatarUrl());

        e.getChannel().sendMessageEmbeds(builder.build()).queue();

    }
//    public void createAction(MessageReceivedEvent e, String[] xAction, String[] xList, EmbedBuilder builder){
//        r = rand.nextInt(xAction.length); rList = rand.nextInt(xList.length);
//        User mentionedUser = e.getMessage().getMentionedUsers().get(0);
//        builder.setImage(xList[rList]);
//        builder.setAuthor(e.getAuthor().getName() + " " + xAction[r] + " " + mentionedUser.getName(), null, e.getAuthor().getAvatarUrl());
//        e.getChannel().sendMessage(builder.build()).queue();
//
//    }

    public void createEmotion(SlashCommandInteraction e, String[] xAction, String[] xList, EmbedBuilder builder){
        r = rand.nextInt(xAction.length); rList = rand.nextInt(xList.length);
        //String actionName = e.getName().substring(4, e.getName().indexOf(" ", 4));
        try{
            String actionName = e.getName().substring(4, e.getName().indexOf(" ", 4));
            if(e.getName().length() > (4 + actionName.length())){
                String message = e.getName().substring(4 + actionName.length());
                builder.setFooter(message);
            }
        } catch (StringIndexOutOfBoundsException ignored){ }

        builder.setImage(xList[rList]);
        builder.setAuthor(e.getUser().getName() + " " + xAction[r], null, e.getUser().getAvatarUrl());
        e.getChannel().sendMessageEmbeds(builder.build()).queue();

    }

//    public void createEmotion(MessageReceivedEvent e, String[] xAction, String[] xList, EmbedBuilder builder){
//        r = rand.nextInt(xAction.length); rList = rand.nextInt(xList.length);
//        builder.setImage(xList[rList]);
//        builder.setAuthor(e.getAuthor().getName() + " " + xAction[r], null, e.getAuthor().getAvatarUrl());
//        e.getChannel().sendMessage(builder.build()).queue();
//
//    }
}
