import { getNameOfDeclaration } from "typescript";
import { Question, QuestionType } from "../models/question";
import { GenderOptions, HobbiesOptions, Jobs, LikeOptions, OlympiadsOptions, YesNoOptions } from "../models/formModel";

export const questions: Question[] = [
    new Question({
        name: "gender",
        question: "Пол",
        description: "",
        options: GenderOptions,
        type: QuestionType.Single,
    }),
    new Question({
        name: "sum_use_score",
        question: "Сумма баллов ЕГЭ за 3 предмета",
        description: "Если сдавали больше экзаменов укажите те, по которым планируете поступать",
        min: 0,
        max: 310,
        type: QuestionType.Numeric,
    }),
    new Question({
        name: "olympiads",
        question: "Принимали ли вы участие в олимпиадах по профильным предметам?",
        description: "Выбирайте только если выходили на уровень выше вашей школы, а если нет, то пропустите вопрос :)",
        options: OlympiadsOptions,
        type: QuestionType.Multiple,
    }),
    new Question({
        name: "hobbies",
        question: "Какие увлечения у вас были, когда вы учились в школе?",
        description: "Если ничего не подходит - ничего страшного, вопрос не обязательный",
        options: HobbiesOptions,
        type: QuestionType.Multiple,
    }),
    new Question({
        name: "web_development",
        question: "Насколько вы любите заниматься Веб-разработкой?",
        description: "",
        options: LikeOptions,
        type: QuestionType.Scale,
    }),
    new Question({
        name: "system_administration",
        question: "Насколько вы любите заниматься Системным администрированием?",
        description: "",
        options: LikeOptions,
        type: QuestionType.Scale,
    }),
    new Question({
        name: "mathematics",
        question: "Насколько вы любите заниматься Математикой?",
        description: "",
        options: LikeOptions,
        type: QuestionType.Scale,
    }),
    new Question({
        name: "hardware",
        question: "Насколько вы любите заниматься Работой с компьютерным оборудованием и сборкой ПК?",
        description: "",
        options: LikeOptions,
        type: QuestionType.Scale,
    }),
    new Question({
        name: "biology",
        question: "Насколько вы любите заниматься Биологией?",
        description: "",
        options: LikeOptions,
        type: QuestionType.Scale,
    }),
    new Question({
        name: "data_science",
        question: "Насколько вы любите заниматься Аналитикой данных?",
        description: "",
        options: LikeOptions,
        type: QuestionType.Scale,
    }),
    new Question({
        name: "design",
        question: "Насколько вы любите заниматься Разработка графических интерфейсов - GUI?",
        description: "",
        options: LikeOptions,
        type: QuestionType.Scale,
    }),
    new Question({
        name: "backend_development",
        question: "Насколько вы любите заниматься Написанием серверной части приложений - Back?",
        description: "",
        options: LikeOptions,
        type: QuestionType.Scale,
    }),
    new Question({
        name: "frontend_development",
        question: "Насколько вы любите заниматься Написанием клиентской части приложений - Front?",
        description: "",
        options: LikeOptions,
        type: QuestionType.Scale,
    }),
    new Question({
        name: "economy",
        question: "Насколько вы любите заниматься Экономикой и финансами?",
        description: "",
        options: LikeOptions,
        type: QuestionType.Scale,
    }),
    new Question({
        name: "hacking",
        question: "Насколько вы любите заниматься Поиском ошибок и уязвимостей на сайтах, в играх или приложениях?",
        description: "",
        options: LikeOptions,
        type: QuestionType.Scale,
    }),
    new Question({
        name: "preferred_it_job",
        question: "Если бы вы могли выбрать только 1 сферу в IT, то что бы выбрали?",
        description: "",
        options: Jobs,
        type: QuestionType.Single,
    }),
    new Question({
        name: "uni_was_my_decision",
        question: "Вы поступили в университет, потому что сами этого хотели?",
        description: "",
        options: YesNoOptions,
        type: QuestionType.Single,
    }),
    new Question({
        name: "is_grades_important",
        question: "Вам важно получать хорошие отметки?",
        description: "",
        options: YesNoOptions,
        type: QuestionType.Single,
    }),
]