package com.example.nowaaplikacja.data;

import java.util.UUID;

public record Student(UUID id, String name, StudentUnit unit, Long index) {

}
