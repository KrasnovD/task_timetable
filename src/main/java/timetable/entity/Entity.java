package timetable.entity;

import javax.persistence.*;

@javax.persistence.Entity
abstract public class Entity {
        @Id
        private Long id;

        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
}
