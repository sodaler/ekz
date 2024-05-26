export interface Group {
    name: string;
}

export interface Room {
    name: string;
}

export interface Teacher {
    fullName: string;
}

export interface Subject {
    name: string;
    teacher: Teacher;
    type: string;
}

export interface Lesson {
    group?: Group;
    room?: Room;
    subject?: Subject;
}

export interface Day {
    lessons: (Lesson | null)[];
}

export interface TimeTableEntry {
    days: Day[];
    isOdd: boolean;
}

export type TimeTableData = TimeTableEntry[];
