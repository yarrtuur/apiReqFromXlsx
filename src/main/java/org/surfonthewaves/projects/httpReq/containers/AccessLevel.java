package org.surfonthewaves.projects.httpReq.containers;

public enum AccessLevel {

        FULL("FULL DATA ACCESS"),
        POLICE("POLICE DATA ACCESS"),
        OTHER("OTHER DATA ACCESS ");

        private String description;

        AccessLevel(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

}
