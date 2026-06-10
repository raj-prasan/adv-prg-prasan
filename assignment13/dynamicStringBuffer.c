
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char   *data;       /* Heap-allocated character buffer (null-terminated). */
    size_t  length;     /* Number of characters stored (excluding '\0').       */
    size_t  capacity;   /* Total bytes allocated for data.                     */
} StringBuffer;


StringBuffer* sb_init(size_t initial_capacity)
{
    if (initial_capacity == 0)
        initial_capacity = 1;

    StringBuffer *sb = malloc(sizeof(StringBuffer));
    if (sb == NULL) {
        fprintf(stderr, "sb_init: failed to allocate StringBuffer struct\n");
        return NULL;
    }

    sb->data = malloc(initial_capacity);
    if (sb->data == NULL) {
        fprintf(stderr, "sb_init: failed to allocate data buffer\n");
        free(sb);           
        return NULL;
    }

    sb->data[0]  = '\0';   
    sb->length   = 0;
    sb->capacity = initial_capacity;
    return sb;
}


int sb_append(StringBuffer *sb, const char *str)
{
    if (sb == NULL || str == NULL)
        return 0;

    size_t str_len     = strlen(str);
    size_t needed      = sb->length + str_len + 1; /* +1 for '\0' */

    if (needed > sb->capacity) {
        size_t new_capacity = sb->capacity;

        
        while (new_capacity < needed)
            new_capacity *= 2;

        
        char *tmp = realloc(sb->data, new_capacity);
        if (tmp == NULL) {
            fprintf(stderr, "sb_append: realloc failed (capacity %zu → %zu)\n",
                    sb->capacity, new_capacity);
            return 0;   
        }

        printf("  [GROW] capacity %zu -> %zu bytes\n",
               sb->capacity, new_capacity);

        sb->data     = tmp;
        sb->capacity = new_capacity;
    }

    memcpy(sb->data + sb->length, str, str_len + 1);
    sb->length += str_len;
    return 1;   /* Success. */
}


void sb_free(StringBuffer **sb)
{
    if (sb == NULL || *sb == NULL)
        return;

    free((*sb)->data);
    free(*sb);
    *sb = NULL;
}



static void sb_print_state(const StringBuffer *sb, const char *label)
{
    printf("  [%-12s] length=%-4zu capacity=%-4zu  data=\"%s\"\n",
           label, sb->length, sb->capacity, sb->data);
}



int main(void)
{
    puts("=== Dynamic String Buffer Demo ===\n");

    StringBuffer *sb = sb_init(8);
    if (sb == NULL)
        return EXIT_FAILURE;

    printf("Initialised: capacity=%zu, length=%zu\n\n", sb->capacity, sb->length);


    const char *words[] = {
        "Hello",        
        ", World",      
        "! Welcome to the Dynamic String Buffer.",   
        " It resizes automatically.",                
        NULL
    };

    for (int i = 0; words[i] != NULL; i++) {
        printf("Appending: \"%s\"\n", words[i]);
        if (!sb_append(sb, words[i])) {
            fprintf(stderr, "Append failed  aborting.\n");
            sb_free(&sb);
            return EXIT_FAILURE;
        }
        sb_print_state(sb, "after append");
        putchar('\n');
    }

    puts("=== Final buffer contents ===");
    printf("  \"%s\"\n", sb->data);
    printf("  length=%zu  capacity=%zu\n\n", sb->length, sb->capacity);
    sb_free(&sb);

    if (sb == NULL)
        puts("sb_free: pointer successfully set to NULL — no dangling pointer.");

    puts("\nAll memory freed. Done.");
    return EXIT_SUCCESS;
}