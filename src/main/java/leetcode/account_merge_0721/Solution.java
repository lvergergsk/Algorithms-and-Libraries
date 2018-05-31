package leetcode.account_merge_0721;

import java.util.*;
//import java.util.logging.Logger;

class Solution {

//    Logger LOGGER = Logger.getLogger(Solution.class.getName());

    class Account {
        private final String name;
        private SortedSet<String> emails;

        Account(String name) {
            this.name = name;
            emails = new TreeSet<>();
        }

        public String getName() {
            return name;
        }

        void addEmail(String email) {
            this.emails.add(email);
        }

        ArrayList<String> getEmails() {
            return new ArrayList(emails);
        }

        void merge(Account account) {
//            if (this.name != account.getName())
//                throw new IllegalArgumentException("Different name sharing a same email address.");
            List<String> newEmails = account.getEmails();
            for (String email : newEmails) this.addEmail(email);
        }

        @Override
        public String toString() {
            return String.format("%s: %s", this.name, this.emails.toString());
        }
    }

    private List<Account> reduce(List<Account> accounts) {
        List<Account> res = new ArrayList<>();
        HashMap<String, Integer> emailToIndex = new HashMap<>();
        int resPtr = 0;
        for (Account account : accounts) {
            List<String> emails = account.getEmails();

            Integer dupAccountIndex = null;
            for (int i = 0; i < emails.size() && dupAccountIndex == null; i++)
                dupAccountIndex = emailToIndex.get(emails.get(i));

            if (dupAccountIndex == null) {
                res.add(account);
                for (String email : emails) emailToIndex.put(email, resPtr);
                resPtr++;
            } else {
                res.get(dupAccountIndex).merge(account);
            }
        }
        return res;
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<Account> resPrep = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        for (List<String> account : accounts) {
            Account parsedAccount = new Account(account.get(0));
            List<String> emails = account.subList(1, account.size());
            for (String email : emails) parsedAccount.addEmail(email);
            resPrep.add(parsedAccount);
        }

//        LOGGER.info("original accounts:\n" + resPrep);

        {
            int prevSize;
            do {
                prevSize = resPrep.size();
                resPrep = reduce(resPrep);
//                LOGGER.info("Reduce to:\n" + resPrep);
            } while (resPrep.size() != prevSize);
        }

        for (Account accountParsed : resPrep) {
            List<String> account = new ArrayList<>();
            account.add(accountParsed.getName());
            account.addAll(accountParsed.getEmails());
            res.add(account);
        }
//        LOGGER.info("\nres = " + res);
        return res;
    }
}
